package com.proj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.proj.service.MemberService;
import com.proj.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired 
	MemberService memberService;
	
	@PostMapping("/saveSignUp")
	@ResponseBody
	//void add(@RequestBody Map request){
	public Integer saveSignUp(@RequestBody MemberVo member){
		//System.out.println("taskController request: "+task);
		Map resultMap = new HashMap<>();
		int addResult = memberService.saveSignUp(member);
		//System.out.println("taskController addResult:"+addResult);
		
		return addResult;
//		if(addResult > 0) {
//			//List<BoardVo> boardList = boardservice.getBoardList();
//			return addResult;
//		}else
//			//데이터 없다고 하고			
//			return 0;

	}
	
//	 @PostMapping("/login")
//	 @ResponseBody 
//	 public boolean login(@RequestBody MemberVo member,HttpSession session){
//		 Map resultMap = new HashMap<>();
//		 //System.out.println("board_id:"+board_id);
//		 MemberVo getMember = memberService.login(member, session); 
//		 if(member.getPw() == getMember.getPw()){
//			 session.setAttribute("userId", getMember.getId());
//			 return true;
//		 }else
//			 return false;
//	 }

	
}
