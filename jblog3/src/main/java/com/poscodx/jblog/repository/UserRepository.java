package com.poscodx.jblog.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.UserVo;

@Repository
public class UserRepository {
	
	private SqlSession sqlSession;
	
	public UserRepository(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insert(UserVo userVo) {
		return sqlSession.insert("user.insert", userVo);
	}

	public UserVo findById(String id) {
		return sqlSession.selectOne("user.findById", id);
	}

	public UserVo findByIdAndPassword(String id, String password) {
		return sqlSession.selectOne("user.findByIdAndPassword", Map.of("id", id, "password", password));
	}

	public boolean findUser(String id) {
		String userId = sqlSession.selectOne("user.findUser", id);
		if (userId == null) {
			return false;
		}
		return true;
	}
}
