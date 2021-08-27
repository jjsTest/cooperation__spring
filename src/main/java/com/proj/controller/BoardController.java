package com.proj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	@AutoWired BoardService boardservice;
	
	private 
	
	@PostMapping("/add")
	void add(@RequestBody Map request){
		System.out.println("request: "+request);
		Map resultMap = new HashMap<>();
		
		//int addResult = boardservice.add(request);
		
//		if(addResult == 0) {
//			resultMap.put("data", "yes");
//		}else {
//			resultMap.put("data", "no");
//		}
	}
	
}
