
package com.nuance.shark.hacks.demo.web.viewmodel;

import java.io.Serializable;
import java.util.Date;

import com.nuance.shark.hacks.demo.common.Validator;
import com.nuance.shark.hacks.demo.model.Patient;

public class PatientDetail implements Serializable {

	private static final long serialVersionUID = 3954531100178984700L;

	private String firstName;
	private String middleName;
	private String lastName;
	private String mrn;
	private Date dob;
	private String sex;

	public PatientDetail() {
		super();
	}

	public PatientDetail(Patient patient) {
		this.setFirstName(patient.getFirstName());
		this.setMiddleName(patient.getMiddleName());
		this.setLastName(patient.getLastName());
		this.setMrn(patient.getMrn());
		if (Validator.isNotEmpty(patient.getDob())) {
			this.setDob(patient.getDob());
		}
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

	public String getMrn() {
		return mrn;
	}

	public void setMrn(String mrn) {
		this.mrn = mrn;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "PatientDetailV1 [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", mrn=" + mrn + ", dob=" + dob + ", sex=" + sex + "]";
	}

}
