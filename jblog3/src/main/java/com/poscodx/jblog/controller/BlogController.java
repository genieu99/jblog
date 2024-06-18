package com.poscodx.jblog.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.poscodx.jblog.security.Auth;
import com.poscodx.jblog.service.AdminService;
import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.FileUploadService;
import com.poscodx.jblog.vo.BlogVo;

@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping({"", "/{categoryNo}", "/{categoryNo}/{postNo}"})
	public String index(
			@PathVariable("id") String id,
			@PathVariable(value="categoryNo", required=false) Long categoryNo,
			@PathVariable(value="postNo", required=false) Long postNo,
			Model model
	) {
		BlogVo blogVo = blogService.getBasic(id);
		model.addAttribute("blog", blogVo);
		return "blog/main";
	}
	
	@Auth
	@GetMapping("/admin/basic")
	public String adminBasic(@PathVariable("id") String id, Model model) {
		BlogVo blogVo = adminService.getBasic(id);
		model.addAttribute("blogVo", blogVo);
		return "blog/admin-basic";
	}
	
	@Auth
	@PostMapping("/admin/basic/update")
	public String adminBasic(@PathVariable("id") String id, BlogVo blogVo, MultipartFile file) {
		String logo = fileUploadService.restore(file);
		
		if (logo != null) {
			blogVo.setLogo(logo);
		}
		
		adminService.updateMain(blogVo);
		servletContext.setAttribute("blogVo", blogVo);
		BlogVo blog = applicationContext.getBean(BlogVo.class);
		BeanUtils.copyProperties(blogVo, blog);
		
		return "redirect:/";
	}
	
	@Auth
	@RequestMapping("/admin/category")
	public String adminCategory(@PathVariable("id") String id) {
		return "blog/admin-category";
	}
	
	@Auth
	@RequestMapping("/admin/write")
	public String adminWrite() {
		return "blog/admin-write";
	}
}
