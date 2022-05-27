package com.example.demo1.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo1.model.Member;
import com.example.demo1.repository.MemberDao;

@SpringBootTest
class Testservice {

	@Autowired
	private MemberService memberService;

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void findAllMem() {
		memberService.findAllM();
		List<Member> list = memberService.findAllM();
		System.out.println("findAllMem: " + list);
	}

	@Test
	void findAllTeacher() {
		memberService.findAllTeacher();
		List<Member> list = memberService.findAllTeacher();
		System.out.println("findAllTeacher: " + list);
	}

	@Test
	void findAllStudent() {
		List<Member> list = memberService.findAllStudent();
		System.out.println("findAllStudent() 已執行" + list);
	}

	@Test
	void findTById(String teacherId) {
		memberService.findTeacherById(teacherId);
		System.out.println("執行findTeacherById()");
	}

	@Test
	void insertMember() {
		memberService.insertMember();
		System.out.println("run insertMember success!");
	}

	@Test
	void updateMember() {
		memberService.updateMember();
	}

	@Test
	void deleteMember() {
		memberService.deleteMember();
		System.out.println();
		System.out.println("run deleteMember success!");
	}

}
