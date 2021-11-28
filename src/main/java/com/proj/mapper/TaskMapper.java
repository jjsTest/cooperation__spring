package com.proj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.proj.vo.TaskVo;

@Mapper
public interface TaskMapper {
	
	public int addTask(TaskVo task);
	
	public List<TaskVo> getTaskList(TaskVo task);
	
	public List<TaskVo> getDetail(TaskVo task);
	
	public int addComment(TaskVo task);
	
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
