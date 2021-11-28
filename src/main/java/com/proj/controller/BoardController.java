package com.proj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.proj.service.BoardService;
import com.proj.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired 
	BoardService boardService;
	//BoardVo BoardVo;
	
	@PostMapping("/add")
	@ResponseBody
	//void add(@RequestBody Map request){
	public Integer add(@RequestBody BoardVo board){
		System.out.println("boardController request: "+board);
		System.out.println("boardController board.name: "+board.getName());
		Map resultMap = new HashMap<>();
		int addResult = boardService.addBoard(board);
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
	@ResponseBody
	public List<BoardVo> select(){
		Map resultMap = new HashMap<>();
		List<BoardVo> boardList = boardService.getBoardList();
		//List boardlists = boardList;
		String boardList_str = new Gson().toJson(boardList);
		System.out.println("boardController select:"+boardList_str);
		//System.out.println("TOTAL_NUM:"+BoardVo.getTotal_num());
		return boardList;
	}
	
	@PostMapping("/selectId")
	@ResponseBody
	public List<BoardVo> selectId(@RequestBody BoardVo board){
		System.out.println("boardController_selectID_boardID:"+board.getId());
		Map resultMap = new HashMap<>();
		List<BoardVo> boardDetail = boardService.getBoardDetail(board);
		//List boardlists = boardList;
		String boardDetail_str = new Gson().toJson(boardDetail);
		System.out.println("boardController select:"+boardDetail_str);
		//System.out.println("TOTAL_NUM:"+BoardVo.getTotal_num());
		return boardDetail;
	}
	
	@PostMapping("/edit")
	@ResponseBody
	//void add(@RequestBody Map request){
	public Integer edit(@RequestBody BoardVo board){
		System.out.println("boardController request: "+board);
		System.out.println("boardController board.name: "+board.getName());
		Map resultMap = new HashMap<>();
		int editResult = boardService.editBoard(board);
		System.out.println("boardController addResult:"+editResult);
		
		return editResult;
	}
	
	@PostMapping("/delete")
	@ResponseBody
	//void add(@RequestBody Map request){
	public Integer delete(@RequestBody BoardVo board){
		System.out.println("boardController request: "+board);
		System.out.println("boardController board.Id: "+board.getId());
		Map resultMap = new HashMap<>();
		int deleteResult = boardService.deleteBoard(board);
		System.out.println("boardController addResult:"+deleteResult);
		
		return deleteResult;
	}
	
}
