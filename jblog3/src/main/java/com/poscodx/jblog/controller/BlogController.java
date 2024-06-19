package com.poscodx.jblog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poscodx.jblog.security.Auth;
import com.poscodx.jblog.service.AdminService;
import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.FileUploadService;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.PostVo;

@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping({"", "/{categoryNo}", "/{categoryNo}/{postNo}"})
	public String index(
			@PathVariable("id") String id,
			@PathVariable("categoryNo") Optional<Long> categoryNo,
			@PathVariable("postNo") Optional<Long> postNo,
			Model model
	) {
		Long pathNo1 = 0L;
		Long pathNo2 = 0L;
		
		if (postNo.isPresent()) {
			pathNo1 = categoryNo.get();
			pathNo2 = postNo.get();
		} else if (categoryNo.isPresent()) {
			pathNo1 = categoryNo.get();
		} else {
			pathNo1 = 1L;
			pathNo2 = 1L;
		}
		
		BlogVo blogVo = blogService.getBasic(id);
		model.addAttribute("blog", blogVo);
		return "blog/main";
	}
	
	@Auth
	@GetMapping("/admin/basic")
	public String adminBasic(@PathVariable("id") String id, Model model) {
		BlogVo blogVo = adminService.getBasic(id);
		model.addAttribute("blog", blogVo);
		return "blog/admin-basic";
	}
	
	@Auth
	@PostMapping("/admin/basic/update")
	public String adminBasic(@PathVariable("id") String id, BlogVo blogVo, @RequestParam("logo-file") MultipartFile file, Model model) {
		String logo = fileUploadService.restore(file);
		
		if (logo != null) {
			blogVo.setLogo(logo);
		}
		
		model.addAttribute("blog", blogVo);
		adminService.updateMain(blogVo);
		
		return "redirect:/" + id + "/admin/basic";
	}
	
	@Auth
	@RequestMapping("/admin/category")
	public String adminCategory(@PathVariable("id") String id) {
		
		return "blog/admin-category";
	}
	
	@Auth
	@GetMapping("/admin/write")
	public String adminWrite() {
		return "blog/admin-write";
	}
	
	@Auth
	@PostMapping("/admin/write")
	public String adminWrite(PostVo postVo) {
		adminService.write(postVo);
		return "blog/admin-write";
	}
}
