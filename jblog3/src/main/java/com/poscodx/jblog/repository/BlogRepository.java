package com.poscodx.jblog.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.PostVo;

@Repository
public class BlogRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void setInitialize(String id) {
		String title = id + "의 블로그";
		String filePath = "/assets/images/spring-logo.jpg";
		sqlSession.insert("blog.setInitialize", Map.of("id", id, "title", title, "filePath", filePath));
	}
	
	public void setInitialCategory(String id) {
		String name = "미분류";
		String description = "초기 카테고리입니다.";
		sqlSession.insert("blog.setInitializeCategory", Map.of("name", name, "description", description, "id", id));
	}

	public BlogVo getBasic(String id) {
		return sqlSession.selectOne("blog.getBasic", id);
	}
	
	public List<PostVo> getPostListByCategory(String id, Long pathNo1) {
		return sqlSession.selectList("blog.getPostListByCategory", Map.of("id", id, "pathNo", pathNo1));
	}
	
	public PostVo getPostByCategory(String id, Long pathNo1) {
		return sqlSession.selectOne("blog.getPostByCategory", Map.of("id", id, "pathNo", pathNo1));
	}

	public Long getInitialPostCategoryNo(String id) {
		return sqlSession.selectOne("blog.getInitialPostCategoryNo", id);
	}

	public Long getInitialPostId(String id) {
		return sqlSession.selectOne("blog.getInitialPostId", id);
	}
}
