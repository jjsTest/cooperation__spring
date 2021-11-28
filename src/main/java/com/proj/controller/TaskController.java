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
import com.proj.service.TaskService;
import com.proj.vo.TaskVo;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired 
	TaskService taskService;
	//BoardVo BoardVo;
	
	@PostMapping("/add")
	@ResponseBody
	//void add(@RequestBody Map request){
	public Integer add(@RequestBody TaskVo task){
		System.out.println("taskController request: "+task);
		Map resultMap = new HashMap<>();
		int addResult = taskService.addTask(task);
		System.out.println("taskController addResult:"+addResult);
		
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
	 public List<TaskVo> select(@RequestBody TaskVo task){
		 Map resultMap = new HashMap<>();
		 //System.out.println("board_id:"+board_id);
		 List<TaskVo> taskList = taskService.getTaskList(task); 
		 //List boardlists =boardList; 
		 System.out.println("##########################1");
		 String taskList_str = new Gson().toJson(taskList);
		 System.out.println("taskController select:"+taskList_str);
		 //System.out.println("TOTAL_NUM:"+BoardVo.getTotal_num()); 
		 
		 return taskList;
	 }

	 @PostMapping("/getDetail")
	 @ResponseBody 
	 public List<TaskVo> getDetail(@RequestBody TaskVo task){
		 Map resultMap = new HashMap<>();
		 List<TaskVo> detail = taskService.getDetail(task); 
		 String detail_str = new Gson().toJson(detail);
		 System.out.println("taskController detail:"+detail_str);
		 //System.out.println("TOTAL_NUM:"+BoardVo.getTotal_num()); 
		  
		 return detail;
	 }
	 
		@PostMapping("/addComment")
		@ResponseBody
		//void add(@RequestBody Map request){
		public Integer addComment(@RequestBody TaskVo task){
			System.out.println("#######################1");
			Map resultMap = new HashMap<>();
			int addResult = taskService.addComment(task);
			//System.out.println("taskController addResult:"+addResult);
			
			return addResult;

		}

}
