package com.poscodx.jblog.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.BlogVo;

@Repository
public class BlogRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void setInitialize(String id) {
		String title = id + "의 블로그";
		String filePath = "/assets/images/spring-logo.jpg";
		sqlSession.insert("blog.setInitialize", Map.of("id", id, "title", title, "filePath", filePath));
	}

	public BlogVo getBasic(String id) {
		return sqlSession.selectOne("blog.getBasic", id);
	}

}
