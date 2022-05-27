package com.example.demo1.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.model.Member;
import com.example.demo1.repository.MemberDao;
import com.example.demo1.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private MemberRepository memberRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Member> findAllM() {

		return memberDao.findAllM();
	}

	public List<Member> findAllTeacher() {

		return memberDao.findAllTeacher();
	}

	public List<Member> findAllStudent() {

		return memberDao.findAllStudent();
	}

	public List<Member> findTeacherById(String teacherId) {

		return memberDao.findTeacherById(teacherId);
	}

	public List<Member> findStudentById(String studentId) {

		return memberDao.findStudentById(studentId);
	}

	public Member insertMember() {

		return memberDao.insertMember();
	}

	public Member updateMember() {

		return memberDao.updateMember();
	}

	public void deleteMember() {

		memberDao.deleteMember();
	}

//	public List<Member> getAllMember() {
//		List<Member> findAll = new ArrayList<Member>();
//		mRepository.findAll().forEach(findAll::add);
//		return findAll;
//	}
//
//	public List<Member> getAllTeacher() {
//		List<Member> allTeacher = new ArrayList<Member>();
//		mRepository.getAllTeacher().forEach(allTeacher::add);
//		return allTeacher;
//	}
//
//	public List<Member> getAllStudent() {
//		List<Member> allStudent = new ArrayList<Member>();
//		mRepository.getAllStudent().forEach(allStudent::add);
//		return allStudent;
//	}

	public Member getTeacher(String teacherId) {
		return memberRepository.getTeacher(teacherId);
	}

	public Member getStudent(String studentId) {
		return memberRepository.getStudent(studentId);
	}

	public Member findById() {
		return memberRepository.QueryById("8");
	}

	public Member DfindById() {
		return memberRepository.QueryById("4");
	}

}
