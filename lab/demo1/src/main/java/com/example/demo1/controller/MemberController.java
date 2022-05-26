package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.model.Member;
import com.example.demo1.repository.MemberDao;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class MemberController {

	@Autowired
	private MemberDao memberDao;

	@RequestMapping("/rest/all-member")
	public List<Member> getAllMember() {
		List<Member> list = memberDao.findAllM();
		return list;
	}

	@RequestMapping("/rest/all-teacher")
	public String getAllTeacher() throws JsonProcessingException {
		String list = memberDao.findAllTeacher();
		return list;
	}

	@RequestMapping("/rest/all-student")
	public String getAllStudent() throws JsonProcessingException {
		String list = memberDao.findAllStudent();
		return list;
	}

	@RequestMapping("/rest/teacherId")
	public String getTeacher(String teacherId) throws JsonProcessingException {
		String teacher = memberDao.findTeacherById(teacherId);
		return teacher;

	}

	@RequestMapping("/rest/studentId")
	public String getStudent(String studentId) throws JsonProcessingException {
		String student = memberDao.findStudentById(studentId);
		return student;
	}

	@RequestMapping("/rest/insert")
	public String insertMember() throws JsonProcessingException {
		String newdata = memberDao.insertMember();
		return newdata;
	}

	@RequestMapping("/rest/update")
	public Member updateMember() {
		Member newdata = memberDao.updateMember();
		return newdata;
	}

	@RequestMapping("/rest/delete")
	public String deleMember() {
		String newdata = memberDao.deleteMember();
		return newdata;
	}

}
