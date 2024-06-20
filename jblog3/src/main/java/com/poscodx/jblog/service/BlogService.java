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
	}
	
	public BlogVo getBasic(String id) {
		return blogRepository.getBasic(id);
	}

	public List<PostVo> getPostList(String id) {
		return blogRepository.getPostList(id);
	}

	public PostVo getPost(String id, Long postNo) {
		return blogRepository.getPost(id, postNo);
	}

	public Long getInitialPostCategoryNo(String id) {
		return blogRepository.getInitialPostCategoryNo(id);
	}
	
	public Long getInitialPostId(String id) {
		return blogRepository.getInitialPostId(id);
	}
}
