package com.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
