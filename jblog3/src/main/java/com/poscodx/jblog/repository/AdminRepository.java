package com.poscodx.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscodx.jblog.vo.BlogVo;
import com.poscodx.jblog.vo.CategoryVo;
import com.poscodx.jblog.vo.PostVo;

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

	public void write(PostVo postVo) {
		sqlSession.insert("admin.write", postVo);
	}

	public List<CategoryVo> getCategory(String id) {
		return sqlSession.selectList("admin.getCategory", id);
	}

	public void addCategory(CategoryVo categoryVo) {
		sqlSession.insert("admin.addCategory", categoryVo);
	}

	public void deleteCategory(Long no) {
		sqlSession.delete("admin.deleteCategory", no);
	}
}
