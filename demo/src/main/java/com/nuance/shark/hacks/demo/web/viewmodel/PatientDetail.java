
package com.nuance.shark.hacks.demo.web.viewmodel;

import java.io.Serializable;
import java.util.Date;

import com.nuance.shark.hacks.demo.common.Validator;
import com.nuance.shark.hacks.demo.model.Patient;

public class PatientDetail implements Serializable {

	private static final long serialVersionUID = 3954531100178984700L;

	private Long patientSid;
	private String mrn;
	private String enterpriseNum;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dob;

	public PatientDetail() {
		super();
	}

	public PatientDetail(Patient patient) {
		this.setPatientSid(patient.getPatientSid());
		this.setMrn(patient.getMrn());
		this.setEnterpriseNum(patient.getEnterpriseNum());
		this.setFirstName(patient.getFirstName());
		this.setMiddleName(patient.getMiddleName());
		this.setLastName(patient.getLastName());
		if (Validator.isNotEmpty(patient.getDob())) {
			this.setDob(patient.getDob());
		}
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
		return "PatientDetail [patientSid=" + patientSid + ", mrn=" + mrn + ", enterpriseNum=" + enterpriseNum
				+ ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", dob=" + dob
				+ "]";
	}

}
