
package com.nuance.shark.hacks.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nuance.shark.hacks.demo.common.EmailUtil;
import com.nuance.shark.hacks.demo.common.SmsUtil;
import com.nuance.shark.hacks.demo.common.Validator;
import com.nuance.shark.hacks.demo.model.PatientFactor;
import com.nuance.shark.hacks.demo.service.PatientService;
import com.nuance.shark.hacks.demo.service.VitalsAIService;

@Service
public class VitalsAIServiceImpl implements VitalsAIService {

	@Autowired
	private PatientService patientService;

	@Override
	@Transactional
	public void checkAndNotify(long patientSid, long factorSid) {
		List<PatientFactor> patientFactorEntity = patientService.findPatientFactors(patientSid, factorSid);
		checkRules(patientFactorEntity);
	}

	/**
	 * @param patientFactorList
	 */
	public void checkRules(List<PatientFactor> patientFactorList) {
		if (patientFactorList != null && patientFactorList.size() >= 3) {
			List<PatientFactor> topThreeList = patientFactorList.subList(0, 3);
			List<PatientFactor> patientFactorEntityNormal = topThreeList.stream()
					.filter(e -> Integer.parseInt(e.getRecordValue()) < 200).collect(Collectors.toList());
			if (Validator.isEmpty(patientFactorEntityNormal)) {
				// configured AI rule has passed , send notification.
				SmsUtil.sendSms();
				EmailUtil.sendEmail();
			}
		}
	}

}
