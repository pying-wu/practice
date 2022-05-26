package com.example.demo1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo1.model.Member;
import com.example.demo1.repository.MemberDao;
import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootTest
class Demo1ApplicationTests {

	@Autowired
	private MemberDao memberDao;

	@Test
	void contextLoads() {
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	void findAllM() {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
		Root<Member> root = criteriaQuery.from(Member.class);

		CriteriaQuery<Member> select = criteriaQuery.select(root);

		TypedQuery<Member> q = entityManager.createQuery(select);
		List<Member> list = q.getResultList();
		System.out.println("list: " + list);
		List<Member> findAll = new ArrayList<Member>();
		list.forEach(findAll::add);
		System.out.println("findAll: " + findAll);
		return;
	}

	@Test
	void findAllMem() {
		memberDao.findAllM();
		List<Member> list = memberDao.findAllM();
		System.out.println("findAllMem: " + list);
	}

	@Test
	void findAllTeacher() throws JsonProcessingException {
		memberDao.findAllTeacher();
		String list = memberDao.findAllTeacher();
		System.out.println("findAllTeacher: " + list);
	}

	@Test
	void findAllStudent() throws JsonProcessingException {
		String list = memberDao.findAllStudent();
		System.out.println("findAllStudent() 已執行" + list);
	}

	@Test
	void findTById(String teacherId) throws JsonProcessingException {
		memberDao.findTeacherById(teacherId);
		System.out.println("執行findTeacherById()");
	}

	@Test
	void insertMember() throws JsonProcessingException {
		memberDao.insertMember();
		System.out.println("run insertMember success!");
	}

	@Test
	void updateMember() {
		memberDao.updateMember();
	}

	@Test
	void deleteMember() {
		memberDao.deleteMember();
		System.out.println("run deleteMember success!");
	}

}
