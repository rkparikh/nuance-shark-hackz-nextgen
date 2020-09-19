
package com.nuance.shark.hacks.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuance.shark.hacks.demo.model.VitalRules;
import com.nuance.shark.hacks.demo.service.VitalsRulesService;

@RestController
@Validated
public class SystemRuleController {

	@Autowired
	private VitalsRulesService vitalsRulesService;

	@GetMapping("/system-rules")
	public ResponseEntity<Object> fetchPatient() {
		List<VitalRules> rules = vitalsRulesService.getAllRules();
		return new ResponseEntity<>(rules, HttpStatus.OK);
	}

}
