package com.poscodx.jblog.repository;

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
}
