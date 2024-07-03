package com.poscodx.jblog.repository;

import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
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

	public <R> R findById(String id, Class<R> resultType) {
		FindByIdResultHandler<R> findByIdResultHandler = new FindByIdResultHandler<>(resultType);
		sqlSession.select("user.findById", id, findByIdResultHandler);
		
		return findByIdResultHandler.result;
	}
	
	private class FindByIdResultHandler<R> implements ResultHandler<Map<String, Object>> {
		private R result;
		private Class<R> resultType;
		
		FindByIdResultHandler(Class<R> resultType) {
			this.resultType = resultType;
		}
		
		@Override
		public void handleResult(ResultContext<? extends Map<String, Object>> resultContext) {
			Map<String, Object> resultMap = resultContext.getResultObject();
			result = new ObjectMapper().convertValue(resultMap, resultType);
		}
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
