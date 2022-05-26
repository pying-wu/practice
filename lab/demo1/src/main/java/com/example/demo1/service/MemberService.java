package com.example.demo1.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo1.model.Member;
import com.example.demo1.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository mRepository;

	public List<Member> getAllMember() {
		List<Member> findAll = new ArrayList<Member>();
		mRepository.findAll().forEach(findAll::add);
		return findAll;
	}

	public List<Member> getAllTeacher() {
		List<Member> allTeacher = new ArrayList<Member>();
		mRepository.getAllTeacher().forEach(allTeacher::add);
		return allTeacher;
	}

	public List<Member> getAllStudent() {
		List<Member> allStudent = new ArrayList<Member>();
		mRepository.getAllStudent().forEach(allStudent::add);
		return allStudent;
	}

	public Member getTeacher(String teacherId) {
		return mRepository.getTeacher(teacherId);
	}

	public Member getStudent(String studentId) {
		return mRepository.getStudent(studentId);
	}

}
