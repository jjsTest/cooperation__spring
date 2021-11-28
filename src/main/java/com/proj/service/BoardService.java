package com.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.proj.mapper.BoardMapper;
import com.proj.vo.BoardVo;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	public int addBoard(BoardVo board) {
		int res = boardMapper.addBoard(board);
		System.out.println("boardService:"+res);
		return res;
	}
	
	public List<BoardVo> getBoardList(){
		List<BoardVo> boardList = boardMapper.getBoardList();
		return boardList;
	}
	
	//id에 해당하는 board 내용 가져오기
	public List<BoardVo> getBoardDetail(BoardVo board){
		List<BoardVo> boardDetail = boardMapper.getBoardDetail(board);
		return boardDetail;
	}
	
	//board 수정
	public int editBoard(BoardVo board) {
		int res = boardMapper.editBoard(board);
		System.out.println("boardService:"+res);
		return res;
	}
	
	//board 삭제
	public int deleteBoard(BoardVo board) {
		int res = boardMapper.deleteBoard(board);
		System.out.println("boardService:"+res);
		return res;
	}
}
