package com.nuance.shark.hacks.demo.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nuance.shark.hacks.demo.model.PatientFactor;

public class VitalsAIServiceImplTest {

	VitalsAIServiceImpl service = null;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCheckRules() throws Exception {
		service = new VitalsAIServiceImpl();
		List<PatientFactor> patientFactorEntity = new ArrayList<>();
		PatientFactor e1 = new PatientFactor();
		e1.setFactorSid(1L);
		e1.setRecordValue("202");
		PatientFactor e2 = new PatientFactor();
		e2.setFactorSid(1L);
		e2.setRecordValue("205");
		PatientFactor e3 = new PatientFactor();
		e3.setFactorSid(1L);
		e3.setRecordValue("242");

		patientFactorEntity.add(e1);
		patientFactorEntity.add(e2);
		patientFactorEntity.add(e3);

		service.checkRules(patientFactorEntity);
		assertTrue(true);
	}

}
