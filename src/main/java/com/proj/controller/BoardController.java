package com.proj.controller;

import java.util.HashMap;
import java.util.List;
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
	public Integer add(@RequestBody BoardVo board){
		System.out.println("boardController request: "+board);
		System.out.println("boardController board.name: "+board.getName());
		Map resultMap = new HashMap<>();
		int addResult = boardservice.addBoard(board);
		System.out.println("boardController addResult:"+addResult);
		
		return addResult;
//		if(addResult > 0) {
//			//List<BoardVo> boardList = boardservice.getBoardList();
//			return addResult;
//		}else
//			//데이터 없다고 하고			
//			return 0;

	}
	
	@PostMapping("/select")
	public List<BoardVo> select(){
		Map resultMap = new HashMap<>();
		List<BoardVo> boardList = boardservice.getBoardList();
		System.out.println("boardController selects:"+boardList.get(0));
		return boardList;
	}
	
}
