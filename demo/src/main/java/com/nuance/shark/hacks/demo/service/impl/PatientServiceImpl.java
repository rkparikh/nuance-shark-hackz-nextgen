
package com.nuance.shark.hacks.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nuance.shark.hacks.demo.dao.PatientDao;
import com.nuance.shark.hacks.demo.entity.PatientEntity;
import com.nuance.shark.hacks.demo.model.Patient;
import com.nuance.shark.hacks.demo.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;

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

}
