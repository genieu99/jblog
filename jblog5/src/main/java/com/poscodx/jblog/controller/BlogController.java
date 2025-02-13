package com.poscodx.jblog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poscodx.jblog.service.AdminService;
import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.FileUploadService;
import com.poscodx.jblog.service.UserService;
import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;
import com.poscodx.jblog.vo.UserVo;

@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {
	
	@Autowired
	private UserService userService;
	
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
		if (!userService.findUser(id)) {
			return "errors/emptyBlog";
		}
		
		BlogVo blogVo = blogService.getBasic(id);
		model.addAttribute("blog", blogVo);
		
		Long pathNo1 = 0L;
		Long pathNo2 = 0L;
		
		List<PostVo> postList = null;
		PostVo postVo = null;
		
		if (postNo.isPresent()) {
			pathNo1 = categoryNo.get();
			pathNo2 = postNo.get();
			
		} else if (categoryNo.isPresent()) {
			pathNo1 = categoryNo.get();
			
		} else {
			pathNo1 = blogService.getInitialPostCategoryNo(id);
			pathNo2 = blogService.getInitialPostId(id);
		}
		
		postList = blogService.getPostListByCategory(id, pathNo1);
		postVo = blogService.getPostByCategory(id, pathNo1);
		
		model.addAttribute("list", postList);
		model.addAttribute("postNow", postVo);
		
		List<CategoryVo> categoryList = adminService.getCategory(id);
		model.addAttribute("category", categoryList);
		
		return "blog/main";
	}
	
	@GetMapping("/admin/basic")
	public String adminBasic(@PathVariable("id") String id, Model model, Authentication authentication) {
		UserVo user = (UserVo)authentication.getPrincipal();
		if (!user.getId().equals(id)) {
			return "errors/accessError";
		}
		BlogVo blogVo = adminService.getBasic(id);
		model.addAttribute("blog", blogVo);
		return "blog/admin-basic";
	}
	
	@PostMapping("/admin/basic/update")
	public String adminBasic(@PathVariable("id") String id, BlogVo blogVo, @RequestParam("logo-file") MultipartFile file, Model model, Authentication authentication) {
		UserVo user = (UserVo)authentication.getPrincipal();
		if (!user.getId().equals(id)) {
			return "errors/accessError";
		}
		
		String logo = fileUploadService.restore(file);
		if (logo != null) {
			blogVo.setLogo(logo);
		}
		
		model.addAttribute("blog", blogVo);
		adminService.updateMain(blogVo);
		return "redirect:/" + id + "/admin/basic";
	}
	
	@GetMapping("/admin/category")
	public String adminCategory(@PathVariable("id") String id, Model model, Authentication authentication) {
		UserVo user = (UserVo)authentication.getPrincipal();
		if (!user.getId().equals(id)) {
			return "errors/accessError";
		}
		
		List<CategoryVo> categoryVo = adminService.getCategory(id);
		model.addAttribute("category", categoryVo);
		
		BlogVo blogVo = adminService.getBasic(id);
		model.addAttribute("blog", blogVo);
		
		return "blog/admin-category";
	}
	
	@PostMapping("/admin/category/add")
	public String adminCategory(@PathVariable("id") String id, CategoryVo categoryVo, Authentication authentication) {
		UserVo user = (UserVo)authentication.getPrincipal();
		if (!user.getId().equals(id)) {
			return "errors/accessError";
		}
		categoryVo.setId(id);
		adminService.addCategory(categoryVo);
		return "redirect:/" + id + "/admin/category";
	}
	
	@RequestMapping("/admin/category/delete/{no}")
	public String deleteAdminCategory(@PathVariable("id") String id, @PathVariable("no") Long no, Authentication authentication, Model model) {
		UserVo user = (UserVo)authentication.getPrincipal();
		if (!user.getId().equals(id)) {
			return "errors/accessError";
		}
		
		try {
			adminService.deleteCategory(no);
		} catch (Exception e) {
			return "redirect:/" + id + "/admin/category?result=fail";
		}
		return "redirect:/" + id + "/admin/category";
	}
	
	@GetMapping("/admin/write")
	public String adminWrite(@PathVariable("id") String id, Model model, Authentication authentication) {
		UserVo user = (UserVo)authentication.getPrincipal();
		if (!user.getId().equals(id)) {
			return "errors/accessError";
		}
		
		BlogVo blogVo = adminService.getBasic(id);
		model.addAttribute("blog", blogVo);
		
		List<CategoryVo> categoryVo = adminService.getCategory(id);
		model.addAttribute("category", categoryVo);
		
		return "blog/admin-write";
	}
	
	@PostMapping("/admin/write")
	public String adminWrite(@PathVariable("id") String id, PostVo postVo, Model model, Authentication authentication) {
		UserVo user = (UserVo)authentication.getPrincipal();
		if (!user.getId().equals(id)) {
			return "errors/accessError";
		}
		
		adminService.write(postVo);
		return "redirect:/" + id;
	}
}
