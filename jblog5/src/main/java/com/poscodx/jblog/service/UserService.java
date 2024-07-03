package com.poscodx.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poscodx.jblog.repository.UserRepository;
import com.poscodx.jblog.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public void join(UserVo userVo) {
		userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
		userRepository.insert(userVo);
	}

	public UserVo getUser(String id) {
		return userRepository.findById(id, UserVo.class);
	}
	
	public UserVo login(String id, String password) {
		return userRepository.findByIdAndPassword(id, password);
	}

	public boolean findUser(String id) {
		return userRepository.findUser(id);
	}
}
