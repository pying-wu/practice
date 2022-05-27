package com.example.demo1.dto;

import java.util.List;

import org.springframework.web.context.annotation.ApplicationScope;

import com.example.demo1.model.Member;

@ApplicationScope
public class Response {

	private String message;
	private String isSuccess;
	private List<Member> resultList;
	private Member singleList;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}

	public List<Member> getResultList() {
		return resultList;
	}

	public void setResultList(List<Member> resultList) {
		this.resultList = resultList;
	}

	public Member getSingleList() {
		return singleList;
	}

	public void setSingleList(Member newdata) {
		this.singleList = newdata;
	}
	
	

}
