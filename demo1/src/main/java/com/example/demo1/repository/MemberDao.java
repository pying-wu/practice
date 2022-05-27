package com.example.demo1.repository;

import java.util.List;

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

@Repository
public class MemberDao {

	@Autowired
	private MemberRepository memberRepository;

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

	public List<Member> findAllTeacher() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
		Root<Member> root = criteriaQuery.from(Member.class);

		Predicate predRole = criteriaBuilder.equal(root.get("role"), "t");
		criteriaQuery.where(predRole);
		TypedQuery<Member> tq = entityManager.createQuery(criteriaQuery);

		System.err.println(tq.getResultList());
		List<Member> list = tq.getResultList();

		return list;
	}

	public List<Member> findAllStudent() {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
		Root<Member> root = criteriaQuery.from(Member.class);
		Predicate predRole = criteriaBuilder.equal(root.get("role"), "s");
		criteriaQuery.where(predRole);
		TypedQuery<Member> tq = entityManager.createQuery(criteriaQuery);

		System.err.println(tq.getResultList());
		List<Member> list = tq.getResultList();

		return list;

	}

	public List<Member> findTeacherById(String teacherId) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
		Root<Member> root = criteriaQuery.from(Member.class);

		Predicate predRole = criteriaBuilder.equal(root.get("role"), "t");
		Predicate predId = criteriaBuilder.equal(root.get("id"), teacherId);
		criteriaQuery.where(predRole, predId);

		TypedQuery<Member> tq = entityManager.createQuery(criteriaQuery);
		List<Member> teacher = tq.getResultList();

		return teacher;
	}

	public List<Member> findStudentById(String studentId) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
		Root<Member> root = criteriaQuery.from(Member.class);

		Predicate predRole = criteriaBuilder.equal(root.get("role"), "s");
		Predicate predId = criteriaBuilder.equal(root.get("id"), studentId);
		criteriaQuery.where(predRole, predId);

		TypedQuery<Member> tq = entityManager.createQuery(criteriaQuery);
		List<Member> student = tq.getResultList();

		return student;
	}

	@Transactional
	public Member insertMember() {

		Member member = new Member();

		member.setId("8");
		member.setName("Lim");
		member.setGender("male");
		member.setSubject("");
		member.setJobTitle("");
		member.setClass1("901");
		member.setAdmissionYearMonth("201708");
		member.setRole("s");
		Member insertdata = memberRepository.save(member);

		return insertdata;
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
	public void deleteMember() {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Member> criteriaDelete = criteriaBuilder.createCriteriaDelete(Member.class);
		Root<Member> rootd = criteriaDelete.from(Member.class);
		criteriaDelete.where(criteriaBuilder.equal(rootd.get("id"), "4"));
		entityManager.createQuery(criteriaDelete).executeUpdate();

	}
}
