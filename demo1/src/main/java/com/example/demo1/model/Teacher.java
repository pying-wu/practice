package com.example.demo1.model;

import javax.persistence.Column;

import lombok.Data;

//@Entity
//@DiscriminatorValue(value = "t")
@Data
public class Teacher extends Member {

	@Column(name = "SUBJECT")
	private String subject;
	@Column(name = "JOB_TITLE")
	private String jobTitle;

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

}
