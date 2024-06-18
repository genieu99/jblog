package com.poscodx.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.BlogVo;

@Repository
public class AdminRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public BlogVo find(String id) {
		return sqlSession.selectOne("admin.find", id);
	}

	public void updateMain(BlogVo blogVo) {
		sqlSession.update("admin.updateMain", blogVo);
	}
}
