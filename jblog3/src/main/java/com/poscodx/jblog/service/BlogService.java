package com.poscodx.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.jblog.repository.BlogRepository;
import com.poscodx.jblog.vo.BlogVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
	public void setInitialize(String id) {
		blogRepository.setInitialize(id);
	}
	
	public BlogVo getBasic(String id) {
		return blogRepository.getBasic(id);
	}
}
