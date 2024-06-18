package com.poscodx.jblog.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.poscodx.jblog.service.BlogService;
import com.poscodx.jblog.service.UserService;
import com.poscodx.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
//	private BlogService blogService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/join")
	public String signup() {
		return "user/join";
	}
	
	@PostMapping("/join")
	public String signup(@ModelAttribute @Valid UserVo userVo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			Map<String, Object> map = result.getModel();
			model.addAllAttributes(map);	
			return "user/join";
		}
		userService.join(userVo);
		System.out.println(userVo.toString());
		// blogService.setInitial(userVo.getId());
		return "redirect:/user/joinsuccess";
	}
	
	@GetMapping("/joinsuccess")
	public String joinsuccess() {
		return "user/joinsuccess";
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
}
