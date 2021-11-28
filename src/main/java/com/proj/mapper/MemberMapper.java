package com.proj.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.proj.vo.JwtRequest;
import com.proj.vo.MemberVo;

@Mapper
public interface MemberMapper {
	
	public int saveSignUp(MemberVo member);
	
	public JwtRequest login(String username);
	
	//public List<TaskVo> getDetail(TaskVo task);
	
	//public int addComment(TaskVo task);
	
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
