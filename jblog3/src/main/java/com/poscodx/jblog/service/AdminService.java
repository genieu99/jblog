package com.poscodx.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.jblog.repository.AdminRepository;
import com.poscodx.jblog.vo.BlogVo;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	public BlogVo getBasic(String id) {
		return adminRepository.find(id);
	}
	
	public void updateMain(BlogVo blogVo) {
		adminRepository.updateMain(blogVo);
	}
}
