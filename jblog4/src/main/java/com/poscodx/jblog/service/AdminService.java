package com.poscodx.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.jblog.repository.AdminRepository;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	public BlogVo getBasic(String id) {
		return adminRepository.findAll(id);
	}
	
	public void updateMain(BlogVo blogVo) {
		adminRepository.updateMain(blogVo);
	}

	public List<CategoryVo> getCategory(String id) {
		return adminRepository.getCategory(id);
	}

	public void addCategory(CategoryVo categoryVo) {
		adminRepository.addCategory(categoryVo);
	}

	public void deleteCategory(Long no) {
		adminRepository.deleteCategory(no);
	}

	public void write(PostVo postVo) {
		adminRepository.write(postVo);
	}
}
