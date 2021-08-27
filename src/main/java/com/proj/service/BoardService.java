package com.proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.dao.BoardDao;

@Service
public class BoardService {
	@Autowired
	private BoardDao boarddao;
}
