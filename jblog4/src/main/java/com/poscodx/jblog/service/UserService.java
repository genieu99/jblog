package com.poscodx.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poscodx.jblog.repository.UserRepository;
import com.poscodx.jblog.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void join(UserVo userVo) {
		userRepository.insert(userVo);
	}

	public UserVo getUser(String id) {
		return userRepository.findById(id);
	}
	
	public UserVo login(String id, String password) {
		return userRepository.findByIdAndPassword(id, password);
	}

	public boolean findUser(String id) {
		return userRepository.findUser(id);
	}
}
