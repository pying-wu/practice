package com.example.demo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Member {

	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	@Column(name = "MEMBER_NAME")
	private String name;
	@Column(name = "GENDER")
	private String gender;

	@Column(name = "SUBJECT")
	private String subject;
	@Column(name = "JOB_TITLE")
	private String jobTitle;
	@Column(name = "CLASS")
	private String class1;
	@Column(name = "ADMISSION_YEAR_MONTH")
	private String admissionYearMonth;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

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
