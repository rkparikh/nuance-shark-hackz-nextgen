package com.nuance.shark.hacks.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PATIENT_FACTOR")

public class PatientFactorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PATIENT_FACTOR_SID", unique = true, nullable = false)
	private Long patientFactorSid;

	@Column(name = "PATIENT_SID")
	private Long patientSid;

	@Column(name = "FACTOR_SID")
	private Long factorSid;

	@Column(name = "RECORD_VALUE")
	private String recordValue;

	@Column(name = "RECORD_ENTRY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date recordEntryDate;

	/**
	 * @return the patientFactorSid
	 */
	public Long getPatientFactorSid() {
		return patientFactorSid;
	}

	/**
	 * @param patientFactorSid the patientFactorSid to set
	 */
	public void setPatientFactorSid(Long patientFactorSid) {
		this.patientFactorSid = patientFactorSid;
	}

	/**
	 * @return the patientSid
	 */
	public Long getPatientSid() {
		return patientSid;
	}

	/**
	 * @param patientSid the patientSid to set
	 */
	public void setPatientSid(Long patientSid) {
		this.patientSid = patientSid;
	}

	/**
	 * @return the factorSid
	 */
	public Long getFactorSid() {
		return factorSid;
	}

	/**
	 * @param factorSid the factorSid to set
	 */
	public void setFactorSid(Long factorSid) {
		this.factorSid = factorSid;
	}

	/**
	 * @return the recordValue
	 */
	public String getRecordValue() {
		return recordValue;
	}

	/**
	 * @param recordValue the recordValue to set
	 */
	public void setRecordValue(String recordValue) {
		this.recordValue = recordValue;
	}

	/**
	 * @return the recordEntryDate
	 */
	public Date getRecordEntryDate() {
		return recordEntryDate;
	}

	/**
	 * @param recordEntryDate the recordEntryDate to set
	 */
	public void setRecordEntryDate(Date recordEntryDate) {
		this.recordEntryDate = recordEntryDate;
	}

}
