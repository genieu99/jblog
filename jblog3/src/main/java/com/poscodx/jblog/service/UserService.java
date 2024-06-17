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
		return userRepository.findById(id);
	}
	
	public UserVo login(String id, String password) {
		return userRepository.findByIdAndPassword(id, password);
	}
}
