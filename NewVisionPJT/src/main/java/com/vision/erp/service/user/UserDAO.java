package com.vision.erp.service.user;

import java.util.List;

import com.vision.erp.common.Search;
import com.vision.erp.service.domain.User;

public interface UserDAO {
	
	public void addUser(User user) throws Exception;
	
	public List<User> selectUserList() throws Exception;

}
