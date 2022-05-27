package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.model.Member;
import com.example.demo1.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/rest/all-member")
	public List<Member> getAllMember() {
		List<Member> list = memberService.findAllM();
		return list;
	}

	@RequestMapping("/rest/all-teacher")
	public List<Member> getAllTeacher() throws DataNotFoundException {
		List<Member> list = memberService.findAllTeacher();
		if (list.size() > 0) {
			return list;
		} else {
			throw new DataNotFoundException("查無任何教師資料");
		}
	}

	@RequestMapping("/rest/all-student")
	public List<Member> getAllStudent() throws DataNotFoundException {
		List<Member> list = memberService.findAllStudent();
		if (list.size() > 0) {
			return list;
		} else {
			throw new DataNotFoundException("查無任何學生資料");
		}
	}

	@RequestMapping("/rest/teacherId")
	public Member getTeacher(String teacherId) throws DataNotFoundException {
		Member teacher = memberService.findTeacherById(teacherId);
		if (teacher != null) {
			return teacher;
		} else {
			throw new DataNotFoundException();
		}

	}

	@RequestMapping("/rest/studentId")
	public Member getStudent(String studentId) throws DataNotFoundException {
		Member student = memberService.findStudentById(studentId);
		if (student != null) {
			return student;
		} else {
			throw new DataNotFoundException();
		}
	}

	@RequestMapping("/rest/insert")
	public Member insertMember() throws DataNotFoundException {
		if (memberService.findById() != null) {
			Member newdata = memberService.insertMember();
			return newdata;
		} else {
			throw new DataNotFoundException("資料庫已有此資料!");
		}
	}

	@RequestMapping("/rest/update")
	public Member updateMember() {
		Member newdata = memberService.updateMember();
		return newdata;
	}

	@RequestMapping("/rest/delete")
	public List<Member> deleMember() throws DataNotFoundException {
		if (memberService.DfindById() != null) {
			memberService.deleteMember();
			List<Member> newdata = memberService.findAllM();
			return newdata;
		} else {
			throw new DataNotFoundException("資料庫中無此資料!");
		}
	}

}
