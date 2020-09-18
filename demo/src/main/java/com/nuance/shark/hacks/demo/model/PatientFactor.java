package com.nuance.shark.hacks.demo.model;

import java.util.Date;

import com.nuance.shark.hacks.demo.entity.PatientFactorEntity;

public class PatientFactor {
	private Long patientFactorSid;
	private Long patientSid;
	private Long factorSid;
	private String recordValue;
	private Date recordEntryDate;

	public PatientFactor() {
	}

	public PatientFactor(PatientFactorEntity entity) {
		this.patientFactorSid = entity.getPatientFactorSid();
		this.patientSid = entity.getPatientSid();
		this.factorSid = entity.getFactorSid();
		this.recordValue = entity.getRecordValue();
		this.recordEntryDate = entity.getRecordEntryDate();
	}

	public void populateEntity(PatientFactorEntity e) {
		e.setPatientSid(this.patientSid);
		e.setFactorSid(this.factorSid);
		e.setRecordValue(this.recordValue);
		e.setRecordEntryDate(this.recordEntryDate);
	}

	public Long getPatientFactorSid() {
		return patientFactorSid;
	}

	public void setPatientFactorSid(Long patientFactorSid) {
		this.patientFactorSid = patientFactorSid;
	}

	public Long getPatientSid() {
		return patientSid;
	}

	public void setPatientSid(Long patientSid) {
		this.patientSid = patientSid;
	}

	public Long getFactorSid() {
		return factorSid;
	}

	public void setFactorSid(Long factorSid) {
		this.factorSid = factorSid;
	}

	public String getRecordValue() {
		return recordValue;
	}

	public void setRecordValue(String recordValue) {
		this.recordValue = recordValue;
	}

	public Date getRecordEntryDate() {
		return recordEntryDate;
	}

	public void setRecordEntryDate(Date recordEntryDate) {
		this.recordEntryDate = recordEntryDate;
	}

}
