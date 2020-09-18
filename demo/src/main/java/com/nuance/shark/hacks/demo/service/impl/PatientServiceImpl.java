
package com.nuance.shark.hacks.demo.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nuance.shark.hacks.demo.dao.PatientDao;
import com.nuance.shark.hacks.demo.dao.PatientFactorDao;
import com.nuance.shark.hacks.demo.entity.PatientEntity;
import com.nuance.shark.hacks.demo.entity.PatientFactorEntity;
import com.nuance.shark.hacks.demo.model.Patient;
import com.nuance.shark.hacks.demo.model.PatientFactor;
import com.nuance.shark.hacks.demo.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;

	@Autowired
	private PatientFactorDao patientFactorDao;

	@Override
	@Transactional
	public Patient findByMrn(String mrn) {
		PatientEntity patientEntity = patientDao.findByMrn(mrn);
		if (patientEntity != null) {
			return new Patient(patientEntity);
		}
		return null;
	}

	@Override
	@Transactional
	public Patient savePatient(Patient patient) {
		PatientEntity patientEntity = patientDao.findByMrn(patient.getMrn());
		if (patientEntity == null) {
			patientEntity = new PatientEntity();
		}
		patient.populateEntity(patientEntity);
		patientDao.save(patientEntity);

		patient.setPatientSid(patientEntity.getPatientSid());
		return patient;
	}

	@Override
	public List<PatientFactor> findPatientFactors(long patientSid, long factorSid) {
		List<PatientFactorEntity> list = patientFactorDao.findByPatientSidAndFactorSid(patientSid, factorSid);
		if (list != null && !list.isEmpty()) {
			List<PatientFactor> result = list.stream().map(PatientFactor::new).collect(Collectors.toList());
			result.sort(Comparator.comparing(PatientFactor::getRecordEntryDate, Comparator.reverseOrder()));
			return result;
		}
		return Collections.emptyList();

	}

	@Override
	public void savePatientFactor(PatientFactor patientFactor) {
		PatientFactorEntity e = new PatientFactorEntity();
		patientFactor.populateEntity(e);
		patientFactorDao.save(e);
	}

}
