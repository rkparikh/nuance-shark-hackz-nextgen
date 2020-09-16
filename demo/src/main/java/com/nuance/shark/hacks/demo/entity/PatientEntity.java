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
@Table(name = "PATIENT")

public class PatientEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PATIENT_SID", unique = true, nullable = false)
	private Long patientSid;

	@Column(name = "FIRST_NAME", length = 64)
	private String firstName;

	@Column(name = "LAST_NAME", length = 64)
	private String lastName;

	@Column(name = "MIDDLE_NAME", length = 64)
	private String middleName;

	@Column(name = "BIRTH_DATE", length = 23)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;

	@Column(name = "GENDER", length = 32)
	private String gender;

	@Column(name = "MRN", length = 32)
	private String mrn;

	public Long getPatientSid() {
		return patientSid;
	}

	public void setPatientSid(Long patientSid) {
		this.patientSid = patientSid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMrn() {
		return mrn;
	}

	public void setMrn(String mrn) {
		this.mrn = mrn;
	}

}
