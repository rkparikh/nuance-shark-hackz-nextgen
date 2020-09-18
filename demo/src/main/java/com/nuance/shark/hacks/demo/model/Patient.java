
package com.nuance.shark.hacks.demo.model;

import java.util.Date;

import com.nuance.shark.hacks.demo.entity.PatientEntity;

public class Patient {
	private Long patientSid;
	private String mrn;
	private String enterpriseNum;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dob;

	public Patient() {
	}

	
	public Patient(PatientEntity patientEntity) {
		this.setPatientSid(patientEntity.getPatientSid());
		this.setMrn(patientEntity.getMrn());
		this.setFirstName(patientEntity.getFirstName());
		this.setMiddleName(patientEntity.getMiddleName());
		this.setLastName(patientEntity.getLastName());
		this.setDob(patientEntity.getDob());
	}

	public void populateEntity(PatientEntity patientEntity) {
		if (patientSid != null) {
			patientEntity.setPatientSid(patientSid);
		}
		patientEntity.setDob(this.getDob());
		patientEntity.setFirstName(this.getFirstName());
		patientEntity.setLastName(this.getLastName());
		patientEntity.setMiddleName(this.getMiddleName());
		patientEntity.setMrn(this.getMrn());
	}

	public Long getPatientSid() {
		return patientSid;
	}

	public void setPatientSid(Long patientSid) {
		this.patientSid = patientSid;
	}

	public String getMrn() {
		return mrn;
	}

	public void setMrn(String mrn) {
		this.mrn = mrn;
	}

	public String getEnterpriseNum() {
		return enterpriseNum;
	}

	public void setEnterpriseNum(String enterpriseNum) {
		this.enterpriseNum = enterpriseNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Patient [patientSid=" + patientSid + ", mrn=" + mrn + ", enterpriseNum=" + enterpriseNum
				+ ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", dob=" + dob
				+ "]";
	}

}
