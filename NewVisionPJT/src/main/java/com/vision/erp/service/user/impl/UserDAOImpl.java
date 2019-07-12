package com.vision.erp.service.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.User;
import com.vision.erp.service.user.UserDAO;
@Repository("userDAOImpl")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	@Qualifier("sqlSession")
	private SqlSession sqlSession;
	
	@Override
	public List<User> selectUserList() throws Exception {
		return sqlSession.selectList("UserMapper.selectUserList");
		
	}

	public void addUser(User user) throws Exception{
		sqlSession.insert("UserMapper.addUser",user);
	}
}
