package com.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.mapper.TaskMapper;
import com.proj.vo.TaskVo;

@Service
public class TaskService {
	@Autowired
	private TaskMapper taskMapper;
	
	public int addTask(TaskVo task) {
		int res = taskMapper.addTask(task);
		System.out.println("teskService:"+res);
		return res;
	}
	
	public List<TaskVo> getTaskList(TaskVo task){
		List<TaskVo> taskList = taskMapper.getTaskList(task);
		return taskList;
	}
	
	public List<TaskVo> getDetail(TaskVo task){
		List<TaskVo> detail = taskMapper.getDetail(task);
		System.out.println("taskService getDetail:"+detail);
		return detail;
	}
	
	public int addComment(TaskVo task) {
		int res = taskMapper.addComment(task);
		System.out.println("teskService:"+res);
		return res;
	}

}
