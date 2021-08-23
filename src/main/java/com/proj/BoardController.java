package com.proj;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {

	@PostMapping("/add")
	void add(HttpServletRequest request){
		String name = (String)request.getAttribute("name");
		int count = (int)request.getAttribute("count");
		// db insert
	}
	
}
