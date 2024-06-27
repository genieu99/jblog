package com.poscodx.jblog.controller.api;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poscodx.jblog.service.UserService;
import com.poscodx.jblog.vo.UserVo;

@RestController("userApiController")
@RequestMapping("/user/api")
public class UserApiController {
	
	private UserService userService;
	
	public UserApiController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/checkid")
	public Object checkId(@RequestParam(value="id", required=true, defaultValue="") String id) {
		UserVo userVo = userService.getUser(id);
		return Map.of("exist", userVo != null);
	}
}