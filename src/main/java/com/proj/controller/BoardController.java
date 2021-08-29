package com.proj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proj.service.BoardService;
import com.proj.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired 
	BoardService boardservice;
	
	@PostMapping("/add")
	//void add(@RequestBody Map request){
	void add(@RequestBody BoardVo board){
		System.out.println("boardController request: "+board);
		System.out.println("boardController board.name: "+board.getName());
		Map resultMap = new HashMap<>();
		
		int addResult = boardservice.addBoard(board);
		System.out.println("boardController addResult:"+addResult);
		
//		if(addResult == 0) {
//			resultMap.put("data", "yes");
//		}else {
//			resultMap.put("data", "no");
//		}
	}
	
}
