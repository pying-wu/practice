package com.example.demo1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.dto.Response;
import com.example.demo1.model.Member;
import com.example.demo1.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/rest/all-member")
	public List<Member> getAllMember() {
		List<Member> list = memberService.findAllM();
		return list;
	}

	@RequestMapping("/rest/all-teacher")
	public Response getAllTeacher() {
		List<Member> list = memberService.findAllTeacher();
		Response response = new Response();

		if (!list.isEmpty()) {
			response.setMessage("查詢成功");
			response.setIsSuccess("true");
			response.setResultList(list);

		} else {
			response.setMessage("查詢失敗");
			response.setIsSuccess("false");
		}
		return response;
	}

	@RequestMapping("/rest/all-student")
	public Response getAllStudent() {
		List<Member> list = memberService.findAllStudent();
		Response response = new Response();

		if (!list.isEmpty()) {
			response.setMessage("查詢成功");
			response.setIsSuccess("true");
			response.setResultList(list);

		} else {
			response.setMessage("查詢失敗");
			response.setIsSuccess("false");
		}
		return response;
	}

	@RequestMapping("/rest/teacherId")
	public Response getTeacher(@RequestParam String teacherId) {
		List<Member> teacher = memberService.findTeacherById(teacherId);
		Response response = new Response();
		List<Member> result = new ArrayList<Member>();
		Member mList = new Member();

		if (!teacher.isEmpty()) {
			response.setMessage("查詢成功");
			response.setIsSuccess("true");

			for (Member member : teacher) {
				mList.setId(member.getId());
				mList.setName(member.getName());
				mList.setGender(member.getGender());
				mList.setSubject(member.getSubject());
				mList.setJobTitle(member.getJobTitle());
				result.add(mList);
			}
			response.setResultList(result);
		} else {
			response.setMessage("查詢失敗");
			response.setIsSuccess("false");
		}
		return response;

	}

	@RequestMapping("/rest/studentId")
	public Response getStudent(@RequestParam String studentId) {
		List<Member> student = memberService.findStudentById(studentId);
		Response response = new Response();
		List<Member> result = new ArrayList<Member>();
		Member mList = new Member();

		if (!student.isEmpty()) {
			response.setMessage("查詢成功");
			response.setIsSuccess("true");

			for (Member member : student) {
				mList.setId(member.getId());
				mList.setName(member.getName());
				mList.setGender(member.getGender());
				mList.setSubject(member.getClass1());
				mList.setJobTitle(member.getAdmissionYearMonth());
				result.add(mList);
			}
			response.setResultList(result);
		} else {
			response.setMessage("查詢失敗");
			response.setIsSuccess("false");
		}
		return response;
	}

	@RequestMapping("/rest/insert")
	public Response insertMember() {
		Response response = new Response();

		if (memberService.findById() == null) {
			Member newdata = memberService.insertMember();
			response.setMessage("新增成功");
			response.setIsSuccess("true");
			response.setSingleList(newdata);
		} else {
			response.setMessage("新增失敗，資料庫中已有此資料");
			response.setIsSuccess("false");
		}
		return response;
	}

	@RequestMapping("/rest/update")
	public Response updateMember() {
		Member newdata = memberService.updateMember();
		Response response = new Response();

		response.setMessage("更新成功");
		response.setIsSuccess("true");
		response.setSingleList(newdata);

		return response;
	}

	@RequestMapping("/rest/delete")
	public Response deleMember() {
		Response response = new Response();

		if (memberService.DfindById() != null) {
			memberService.deleteMember();
			List<Member> newdata = memberService.findAllM();
			response.setMessage("刪除成功");
			response.setIsSuccess("true");
			response.setResultList(newdata);
		} else {
			response.setMessage("刪除失敗，資料庫中無此資料");
			response.setIsSuccess("false");
		}
		return response;
	}

}
