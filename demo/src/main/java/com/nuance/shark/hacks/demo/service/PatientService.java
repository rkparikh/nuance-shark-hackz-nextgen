package com.nuance.shark.hacks.demo.service;

import com.nuance.shark.hacks.demo.model.Patient;

public interface PatientService {

	Patient findByMrn(String mrn);

	Patient savePatient(Patient patient);

}
