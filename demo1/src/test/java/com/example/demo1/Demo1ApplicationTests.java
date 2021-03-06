package com.example.demo1;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo1.model.Member;
import com.example.demo1.model.Student;
import com.example.demo1.model.Teacher;
import com.example.demo1.service.MemberService;

@SpringBootTest
class Demo1ApplicationTests {

	@Autowired
	private MemberService memberService;

	@Test
	void contextLoads() {
		List<Member> member = memberService.getAllMember();
		for (Member list : member) {
			if (list instanceof Teacher) {
				System.out.println("=====老師");
				System.out.println(list.getId());
				System.out.println(list.getName());
				System.out.println(list.getGender());
				System.out.println(((Teacher) list).getJobTitle());
				System.out.println(((Teacher) list).getSubject());
//			System.out.println(list.getRole());
				System.out.println();
			} else {
				System.out.println("=====學生");
				System.out.println(list.getId());
				System.out.println(list.getName());
				System.out.println(list.getGender());
				System.out.println(((Student) list).getClass1());
				System.out.println(((Student) list).getAdmissionYearMonth());
//				System.out.println(list.getRole());
				System.out.println();
			}

		}
		System.out.println("member: " + memberService.getAllMember());
		List<Member> allteacher = memberService.getAllTeacher();
		System.out.println("allteacher: " + allteacher);
		List<Member> allstudent = memberService.getAllStudent();
		System.out.println("allstudent: " + allstudent);
		Member teacher = memberService.getTeacher("1");
		System.out.println("teacher: " + teacher);
		Member student = memberService.getStudent("1");
		System.out.println("student: " + student);

	}

}
