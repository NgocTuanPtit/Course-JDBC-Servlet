package com.tony_funny.service.impl;

import com.tony_funny.dao.IUserDAO;
import com.tony_funny.dao.impl.UserDAO;
import com.tony_funny.model.UserModel;
import com.tony_funny.service.IUserService;

public class UserService implements IUserService {

	private IUserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
	
}
