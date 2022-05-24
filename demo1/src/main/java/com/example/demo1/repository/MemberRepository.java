package com.example.demo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo1.model.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	@Query(value = "select * from MEMBER where MEMBER_ID=?1", nativeQuery = true)
	public Member QueryById(String id);

	@Query(value = "select * from MEMBER WHERE ADMISSION_YEAR_MONTH =' '", nativeQuery = true)
	public List<Member> getAllTeacher();

	@Query(value = "select * from MEMBER WHERE SUBJECT =' '", nativeQuery = true)
	public List<Member> getAllStudent();

	@Query(value = "select * from MEMBER WHERE ADMISSION_YEAR_MONTH =' ' and MEMBER_ID = ?1", nativeQuery = true)
	public Member getTeacher(String teacherId);

	@Query(value = "select * from MEMBER WHERE SUBJECT =' ' and MEMBER_ID = ?1", nativeQuery = true)
	public Member getStudent(String studentId);

}
