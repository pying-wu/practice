package com.example.demo1.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo1.model.Member;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class MemberDao {

	@Autowired
	MemberRepository memberRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Member> findAllM() {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
		Root<Member> root = criteriaQuery.from(Member.class);

		CriteriaQuery<Member> select = criteriaQuery.select(root);

		TypedQuery<Member> q = entityManager.createQuery(select);
		List<Member> list = q.getResultList();

		return list;
	}

	public String findAllTeacher() throws JsonProcessingException {

		Map<String, Object> rtnInfo = new HashMap<String, Object>();

		if (memberRepository.getAllTeacher() != null) {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
			Root<Member> root = criteriaQuery.from(Member.class);
			System.err.println("111111111111");
			Predicate predRole = criteriaBuilder.equal(root.get("role"), "t");
			criteriaQuery.where(predRole);
			TypedQuery<Member> tq = entityManager.createQuery(criteriaQuery);

			System.err.println(tq.getResultList());
			List<Member> list = tq.getResultList();

			rtnInfo.put("rtnList", list);

		} else {
			rtnInfo.put("alertMsg", "查無資料");
		}
		return new ObjectMapper().writeValueAsString(rtnInfo);

	}

	public String findAllStudent() throws JsonProcessingException {

		Map<String, Object> rtnInfo = new HashMap<String, Object>();

		if (memberRepository.getAllStudent() != null) {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
			Root<Member> root = criteriaQuery.from(Member.class);
			Predicate predRole = criteriaBuilder.equal(root.get("role"), "s");
			criteriaQuery.where(predRole);
			TypedQuery<Member> tq = entityManager.createQuery(criteriaQuery);

			System.err.println(tq.getResultList());
			List<Member> list = tq.getResultList();

			rtnInfo.put("rtnList", list);
		} else {
			rtnInfo.put("alertMsg", "查無資料");
		}
		return new ObjectMapper().writeValueAsString(rtnInfo);
	}

	public String findTeacherById(String teacherId) throws JsonProcessingException {

		Map<String, Object> rtnInfo = new HashMap<String, Object>();

		if (memberRepository.getTeacher("2") != null) {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
			Root<Member> root = criteriaQuery.from(Member.class);

			Predicate predRole = criteriaBuilder.equal(root.get("role"), "t");
			Predicate predId = criteriaBuilder.equal(root.get("id"), "2");
			criteriaQuery.where(predRole, predId);

			TypedQuery<Member> tq = entityManager.createQuery(criteriaQuery);
			Member teacher = tq.getSingleResult();

			rtnInfo.put("rtnList", memberRepository.getTeacher("2"));

		} else {
			rtnInfo.put("alertMsg", "查無資料");
		}
		return new ObjectMapper().writeValueAsString(rtnInfo);
	}

	public String findStudentById(String studentId) throws JsonProcessingException {
		Map<String, Object> rtnInfo = new HashMap<String, Object>();

		if (memberRepository.getStudent("3") != null) {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
			Root<Member> root = criteriaQuery.from(Member.class);

			Predicate predRole = criteriaBuilder.equal(root.get("role"), "s");
			Predicate predId = criteriaBuilder.equal(root.get("id"), "3");
			criteriaQuery.where(predRole, predId);

			TypedQuery<Member> tq = entityManager.createQuery(criteriaQuery);
			Member student = tq.getSingleResult();

			rtnInfo.put("rtnList", memberRepository.getStudent("3"));
		} else {
			rtnInfo.put("alertMsg", "查無資料");
		}
		return new ObjectMapper().writeValueAsString(rtnInfo);
	}

	@Transactional
	public String insertMember() throws JsonProcessingException {

		Map<String, Object> rtnInfo = new HashMap<String, Object>();
		Member member = new Member();
		if (memberRepository.QueryById("8") != null) {
			rtnInfo.put("alertMsg", "新增失敗，此帳號已存在");
		} else {
			member.setId("8");
			member.setName("Lim");
			member.setGender("male");
			member.setSubject("");
			member.setJobTitle("");
			member.setClass1("901");
			member.setAdmissionYearMonth("201708");
			member.setRole("s");
			memberRepository.save(member);
			rtnInfo.put("rtnList", member);
		}
		return new ObjectMapper().writeValueAsString(rtnInfo);
	}

	@Transactional
	public Member updateMember() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Member> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Member.class);

		Root root = criteriaUpdate.from(Member.class);
		criteriaUpdate.set("name", "Hebe");
		criteriaUpdate.where(criteriaBuilder.equal(root.get("id"), "2"));

		entityManager.createQuery(criteriaUpdate).executeUpdate();

		CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
		Root<Member> ro = criteriaQuery.from(Member.class);
		Predicate predId = criteriaBuilder.equal(ro.get("id"), "2");
		criteriaQuery.where(predId);

		TypedQuery<Member> tq = entityManager.createQuery(criteriaQuery);
		Member newdata = tq.getSingleResult();

		return newdata;
	}

	@Transactional
	public String deleteMember() {

		if (memberRepository.QueryById("4") != null) {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaDelete<Member> criteriaDelete = criteriaBuilder.createCriteriaDelete(Member.class);
			Root<Member> rootd = criteriaDelete.from(Member.class);
			criteriaDelete.where(criteriaBuilder.equal(rootd.get("id"), "4"));
			entityManager.createQuery(criteriaDelete).executeUpdate();

			String msg = "刪除成功";
			return msg;
		} else {
			String msg = "資料庫查無此資料!";
			return msg;
		}
	}

}
