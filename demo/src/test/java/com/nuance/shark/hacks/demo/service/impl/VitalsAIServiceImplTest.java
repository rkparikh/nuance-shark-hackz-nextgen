package com.nuance.shark.hacks.demo.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nuance.shark.hacks.demo.entity.PatientFactorEntity;

public class VitalsAIServiceImplTest {

	VitalsAIServiceImpl  service = null;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCheckRules() throws Exception {
		service = new VitalsAIServiceImpl();
		List<PatientFactorEntity> patientFactorEntity = new ArrayList<>();
		PatientFactorEntity e1 = new PatientFactorEntity();
		e1.setFactorSid(1L);
		e1.setRecordValue("202");
		PatientFactorEntity e2 = new PatientFactorEntity();
		e2.setFactorSid(1L);
		e2.setRecordValue("205");
		PatientFactorEntity e3 = new PatientFactorEntity();
		e3.setFactorSid(1L);
		e3.setRecordValue("242");
		
		patientFactorEntity.add(e1);
		patientFactorEntity.add(e2);
		patientFactorEntity.add(e3);
		
		service.checkRules(patientFactorEntity);
		assertTrue(true);
	}

}
