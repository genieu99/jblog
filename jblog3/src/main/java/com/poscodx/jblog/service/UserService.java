package com.poscodx.jblog.service;

import org.springframework.stereotype.Service;

import com.poscodx.jblog.repository.UserRepository;
import com.poscodx.jblog.vo.UserVo;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void join(UserVo userVo) {
		userRepository.insert(userVo);
	}

	public UserVo getUser(String id) {
		System.out.println("확인");
		System.out.println(userRepository.findById(id));
		return userRepository.findById(id);
	}
}