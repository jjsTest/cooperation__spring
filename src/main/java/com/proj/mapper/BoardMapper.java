package com.proj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.proj.vo.BoardVo;

@Mapper
public interface BoardMapper {
	
	public int addBoard(BoardVo board);
	
	public List<BoardVo> getBoardList();
	/*
	 * public List<BoardMapper> findList();
	 * 
	 * public BoardMapper findOneByCode(String codes);
	 * 
	 * public void save(BoardMapper student);
	 * 
	 * public void update(BoardMapper student);
	 * 
	 * public void deleteById(Integer id);
	 */
}
