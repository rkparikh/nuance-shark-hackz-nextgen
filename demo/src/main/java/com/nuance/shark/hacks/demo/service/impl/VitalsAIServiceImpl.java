
package com.nuance.shark.hacks.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nuance.shark.hacks.demo.common.EmailUtil;
import com.nuance.shark.hacks.demo.common.SmsUtil;
import com.nuance.shark.hacks.demo.common.Validator;
import com.nuance.shark.hacks.demo.dao.PatientFactorDao;
import com.nuance.shark.hacks.demo.entity.PatientFactorEntity;
import com.nuance.shark.hacks.demo.service.VitalsAIService;

@Service
public class VitalsAIServiceImpl implements VitalsAIService {

	@Autowired
	private PatientFactorDao patientFactorDao;

	@Override
	@Transactional
	public void checkAndNotify() {
		List<PatientFactorEntity> patientFactorEntity = patientFactorDao.findByFactorSid(new Long("1"));
		checkRules(patientFactorEntity);
	}

	/**
	 * @param patientFactorEntity
	 */
	public void checkRules(List<PatientFactorEntity> patientFactorEntity) {
		if (patientFactorEntity != null && patientFactorEntity.size() == 3) {
			List<PatientFactorEntity> patientFactorEntityNormal = patientFactorEntity.stream()
					.filter(e -> Integer.parseInt(e.getRecordValue()) < 200).collect(Collectors.toList());
			if (Validator.isEmpty(patientFactorEntityNormal)) {
				// configured AI rule has passed , send notification.
				SmsUtil.sendSms();
				EmailUtil.sendEmail();
			}
		}
	}

}
