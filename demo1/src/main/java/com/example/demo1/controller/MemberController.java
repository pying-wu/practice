package com.example.demo1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo1.model.Member;
import com.example.demo1.model.Student;
import com.example.demo1.model.Teacher;

@RestController
public class MemberController {

	public List<Member> addlist() {
		List<Member> memberList = new ArrayList<>();
		Teacher t = new Teacher();
		t.setId("1");
		t.setName("Billy");
		t.setGender("male");
		t.setSubject("數學");
		t.setJobTitle("教務主任");
		memberList.add(t);
		Teacher t1 = new Teacher();
		t1.setId("2");
		t1.setName("Heidi");
		t1.setGender("female");
		t1.setSubject("英文");
		t1.setJobTitle("教師");
		memberList.add(t1);
		Student s = new Student();
		s.setId("3");
		s.setName("Jacky");
		s.setGender("male");
		s.setClass1("301");
		s.setAdmissionYearMonth("201910");
		memberList.add(s);
		Student s1 = new Student();
		s1.setId("4");
		s1.setName("Lawrence");
		s1.setGender("male");
		s1.setClass1("801");
		s1.setAdmissionYearMonth("201812");
		memberList.add(s1);
		return memberList;
	}

	@RequestMapping("/rest/all-teacher")
	public List<Member> member1() {
		List<Member> memberList = new ArrayList<>();
		memberList = addlist();
		List<Member> li = new ArrayList<>();
		for (Member mem1 : memberList) {
			if (mem1 instanceof Teacher) {
				Teacher mem = new Teacher();
				String id1 = mem1.getId();
				String name1 = mem1.getName();
				String gender1 = mem1.getGender();
				String subject1 = ((Teacher) mem1).getSubject();
				String job1 = ((Teacher) mem1).getJobTitle();
				mem.setId(id1);
				mem.setGender(gender1);
				mem.setName(name1);
				mem.setSubject(subject1);
				mem.setJobTitle(job1);
				li.add(mem);
			} else {
			}
		}
		return li;
	}

	@RequestMapping("/rest/all-student")
	public List<Member> member2() {
		List<Member> memberList = new ArrayList<>();
		memberList = addlist();
		List<Member> li = new ArrayList<>();
		for (Member mem1 : memberList) {
			if (mem1 instanceof Student) {
				Student student = new Student();
				String id1 = mem1.getId();
				String name1 = mem1.getName();
				String gender1 = mem1.getGender();
				String class11 = ((Student) mem1).getClass1();
				String year1 = ((Student) mem1).getAdmissionYearMonth();
				student.setId(id1);
				student.setName(name1);
				student.setGender(gender1);
				student.setClass1(class11);
				student.setAdmissionYearMonth(year1);
				li.add(student);
			} else {
			}
		}
		return li;
	}

	@RequestMapping("/rest/student")
	public List<Member> findMember3(@RequestParam String id) {
		List<Member> memberList = new ArrayList<>();
		memberList = addlist();
		List<Member> li = new ArrayList<>();
		for (Member mem1 : memberList) {
			if ((mem1.getId()).equals(id)) {
				if (mem1 instanceof Teacher) {
					Teacher mem = new Teacher();
					String id1 = mem1.getId();
					String name1 = mem1.getName();
					String gender1 = mem1.getGender();
					String subject1 = ((Teacher) mem1).getSubject();
					String job1 = ((Teacher) mem1).getJobTitle();
					mem.setId(id1);
					mem.setGender(gender1);
					mem.setName(name1);
					mem.setSubject(subject1);
					mem.setJobTitle(job1);
					li.add(mem);
				} else {
					Student student = new Student();
					String id1 = mem1.getId();
					String name1 = mem1.getName();
					String gender1 = mem1.getGender();
					String class11 = ((Student) mem1).getClass1();
					String year1 = ((Student) mem1).getAdmissionYearMonth();
					student.setId(id1);
					student.setName(name1);
					student.setGender(gender1);
					student.setClass1(class11);
					student.setAdmissionYearMonth(year1);
					li.add(student);
				}
			}
		}
		return li;
	}
}
