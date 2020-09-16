
package com.nuance.shark.hacks.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nuance.shark.hacks.demo.model.Patient;
import com.nuance.shark.hacks.demo.service.PatientService;
import com.nuance.shark.hacks.demo.web.viewmodel.PatientDetail;

@RestController
@Validated
public class PatientController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private Gson gson;

	@GetMapping("/patients/{mrn}")
	public ResponseEntity<Object> fetchPatient(@PathVariable(name = "mrn") String mrn) {
		PatientDetail response;
		Patient patient = patientService.findByMrn(mrn);
		if (patient == null) {
			response = new PatientDetail();
		} else {
			response = new PatientDetail(patient);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	public Gson getGson() {
		return gson;
	}

	public void setGson(Gson gson) {
		this.gson = gson;
	}

}
