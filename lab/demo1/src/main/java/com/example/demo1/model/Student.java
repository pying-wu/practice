package com.example.demo1.model;

import javax.persistence.Column;

import lombok.Data;

//@Entity
//@DiscriminatorValue(value = "s")
@Data
public class Student extends Member {

	@Column(name = "CLASS")
	private String class1;
	@Column(name = "ADMISSION_YEAR_MONTH")
	private String admissionYearMonth;

	public String getClass1() {
		return class1;
	}

	public void setClass1(String class1) {
		this.class1 = class1;
	}

	public String getAdmissionYearMonth() {
		return admissionYearMonth;
	}

	public void setAdmissionYearMonth(String admissionYearMonth) {
		this.admissionYearMonth = admissionYearMonth;
	}

}
