
package com.nuance.shark.hacks.demo.web.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nuance.shark.hacks.demo.model.Patient;
import com.nuance.shark.hacks.demo.model.PatientFactor;
import com.nuance.shark.hacks.demo.service.PatientService;
import com.nuance.shark.hacks.demo.service.VitalsAIService;
import com.nuance.shark.hacks.demo.web.viewmodel.PatientDetail;
import com.nuance.shark.hacks.demo.web.viewmodel.PatientFactorVM;

@RestController
@Validated
public class PatientController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private VitalsAIService vitalsAIService;

	@GetMapping("/patient/detail/{mrn}")
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

	@GetMapping("/patient/factors/{patientSid}/{factorSid}")
	public ResponseEntity<Object> fetchPatientFactors(@PathVariable(name = "patientSid") long patientSid,
			@PathVariable(name = "factorSid") long factorSid) {
		List<PatientFactor> resultList = patientService.findPatientFactors(patientSid, factorSid);
		List<PatientFactorVM> response = resultList.stream().map(PatientFactorVM::new).collect(Collectors.toList());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/patient/factor/save")
	public ResponseEntity<Object> savePatientFactors(@RequestBody PatientFactorVM patientFactorVM) throws Exception {
		PatientFactor patientFactor = new PatientFactor();
		patientFactor.setPatientSid(patientFactorVM.getPatientSid());
		patientFactor.setFactorSid(patientFactorVM.getFactorSid());
		patientFactor.setRecordValue(patientFactorVM.getRecordValue());

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		patientFactor.setRecordEntryDate(sdf.parse(patientFactorVM.getRecordEntryDate()));
		patientService.savePatientFactor(patientFactor);
		vitalsAIService.checkAndNotify(patientFactor.getPatientSid(), patientFactor.getFactorSid());
		return new ResponseEntity<>(HttpStatus.OK, HttpStatus.OK);
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	public void setVitalsAIService(VitalsAIService vitalsAIService) {
		this.vitalsAIService = vitalsAIService;
	}

}
