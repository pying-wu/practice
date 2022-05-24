package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.model.Member;
import com.example.demo1.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/rest/all-member")
	public List<Member> getAllMember() {
		System.err.println("====執行getAllMember===");
		return memberService.getAllMember();
	}

	@RequestMapping("/rest/all-teacher")
	public List<Member> getAllTeacher() {
		System.err.println("====執行getAllTeacher===");
		return memberService.getAllTeacher();
//		List<Member> memberList = new ArrayList<Member>();
//		mService.getAllTeacher();
//		System.out.println(mList);
//		List<Member> li = new ArrayList<>();
//		for (Member mem1 : memberList) {
//			if (mem1 instanceof Teacher) {
//				Teacher mem = new Teacher();
//				String id1 = mem1.getId();
//				String name1 = mem1.getName();
//				String gender1 = mem1.getGender();
//				String subject1 = ((Teacher) mem1).getSubject();
//				String job1 = ((Teacher) mem1).getJobTitle();
//				mem.setId(id1);
//				mem.setGender(gender1);
//				mem.setName(name1);
//				mem.setSubject(subject1);
//				mem.setJobTitle(job1);
//				li.add(mem);
//			} else {
//			}
//		}
//		return li;
	}

	@RequestMapping("/rest/all-student")
	public List<Member> getAllStudent() {
		System.err.println("====執行getAllTeacher===");
		return memberService.getAllStudent();
//		List<Member> memberList = new ArrayList<>();
////		memberList = addlist();
//		List<Member> li = new ArrayList<>();
//		for (Member mem1 : memberList) {
//			if (mem1 instanceof Student) {
//				Student student = new Student();
//				String id1 = mem1.getId();
//				String name1 = mem1.getName();
//				String gender1 = mem1.getGender();
//				String class11 = ((Student) mem1).getClass1();
//				String year1 = ((Student) mem1).getAdmissionYearMonth();
//				student.setId(id1);
//				student.setName(name1);
//				student.setGender(gender1);
//				student.setClass1(class11);
//				student.setAdmissionYearMonth(year1);
//				li.add(student);
//			} else {
//			}
//		}
//		return li;
	}

//	@RequestMapping("/rest/Id")
//	public List<Member> QueryById(String id) {
//		return null;
//	}

	@RequestMapping("/rest/teacherId")
	public Member getTeacher(@RequestParam String teacherId) {
		return memberService.getTeacher(teacherId);
	}

	@RequestMapping("/rest/studentId")
	public Member getStudent(@RequestParam String studentId) {
		return memberService.getStudent(studentId);
	}

//	@RequestMapping("/rest/student")
//	public List<Member> findMember3(@RequestParam String id) {
//		List<Member> memberList = new ArrayList<>();
////		memberList = addlist();
//		List<Member> li = new ArrayList<>();
//		for (Member mem1 : memberList) {
//			if ((mem1.getId()).equals(id)) {
//				if (mem1 instanceof Teacher) {
//					Teacher mem = new Teacher();
//					String id1 = mem1.getId();
//					String name1 = mem1.getName();
//					String gender1 = mem1.getGender();
//					String subject1 = ((Teacher) mem1).getSubject();
//					String job1 = ((Teacher) mem1).getJobTitle();
//					mem.setId(id1);
//					mem.setGender(gender1);
//					mem.setName(name1);
//					mem.setSubject(subject1);
//					mem.setJobTitle(job1);
//					li.add(mem);
//				} else {
//					Student student = new Student();
//					String id1 = mem1.getId();
//					String name1 = mem1.getName();
//					String gender1 = mem1.getGender();
//					String class11 = ((Student) mem1).getClass1();
//					String year1 = ((Student) mem1).getAdmissionYearMonth();
//					student.setId(id1);
//					student.setName(name1);
//					student.setGender(gender1);
//					student.setClass1(class11);
//					student.setAdmissionYearMonth(year1);
//					li.add(student);
//				}
//			}
//		}
//		return li;
//	}
}
