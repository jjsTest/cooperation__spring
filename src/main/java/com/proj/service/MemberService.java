package com.proj.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.mapper.MemberMapper;
import com.proj.vo.MemberVo;

@Service
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	public int saveSignUp(MemberVo member) {
		int res = memberMapper.saveSignUp(member);
		//System.out.println("teskService:"+res);
		return res;
	}
	
//	public MemberVo login(MemberVo member, HttpSession session){
//		MemberVo getMember = memberMapper.login(member);
//		if(member.getPw()==getMember.getPw()) {
//			session.setAttribute("userId", getMember.getId());
//		}
//		return getMember;
//	}
	
//	public List<TaskVo> getDetail(TaskVo task){
//		System.out.println("TaskVo.board_id:"+task.getBoard_id());
//		System.out.println("TaskVo.task_id:"+task.getTask_id());
//		List<TaskVo> detail = taskMapper.getDetail(task);
//		System.out.println("task getDetail:"+detail);
//		return detail;
//	}
//	
//	public int addComment(TaskVo task) {
//		int res = taskMapper.addComment(task);
//		System.out.println("teskService:"+res);
//		return res;
//	}

}
