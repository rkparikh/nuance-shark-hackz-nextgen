package com.nuance.shark.hacks.demo.service;

import java.util.List;

import com.nuance.shark.hacks.demo.model.Patient;
import com.nuance.shark.hacks.demo.model.PatientFactor;

public interface PatientService {

	Patient findByMrn(String mrn);

	Patient savePatient(Patient patient);

	List<PatientFactor> findPatientFactors(long patientSid, long factorSid);

	void savePatientFactor(PatientFactor patientFactor);

}
