package com.poscodx.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.jblog.repository.BlogRepository;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.PostVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
	public void setInitialize(String id) {
		blogRepository.setInitialize(id);
		blogRepository.setInitialCategory(id);
		
		int categoryNo = blogRepository.findInitialCategory(id);
		blogRepository.setInitialPost(id, categoryNo);
	}
	
	public BlogVo getBasic(String id) {
		return blogRepository.getBasic(id);
	}

	public List<PostVo> getPostListByCategory(String id, Long pathNo1) {
		return blogRepository.getPostListByCategory(id, pathNo1);
	}

	public PostVo getPostByCategory(String id, Long pathNo1) {
		return blogRepository.getPostByCategory(id, pathNo1);
	}

	public Long getInitialPostCategoryNo(String id) {
		return blogRepository.getInitialPostCategoryNo(id);
	}
	
	public Long getInitialPostId(String id) {
		return blogRepository.getInitialPostId(id);
	}
}
