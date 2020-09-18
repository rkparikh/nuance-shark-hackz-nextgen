package com.nuance.shark.hacks.demo.web.viewmodel;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.nuance.shark.hacks.demo.model.PatientFactor;

public class PatientFactorVM implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long patientFactorSid;
	private Long patientSid;
	private Long factorSid;
	private String recordValue;
	private String recordEntryDate;

	public PatientFactorVM() {
	}

	public PatientFactorVM(PatientFactor pFactor) {
		this.patientFactorSid = pFactor.getPatientFactorSid();
		this.patientSid = pFactor.getPatientSid();
		this.factorSid = pFactor.getFactorSid();
		this.recordValue = pFactor.getRecordValue();
		if (pFactor.getRecordEntryDate() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			this.recordEntryDate = sdf.format(pFactor.getRecordEntryDate());
		}
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

	public String getRecordEntryDate() {
		return recordEntryDate;
	}

	public void setRecordEntryDate(String recordEntryDate) {
		this.recordEntryDate = recordEntryDate;
	}

}
