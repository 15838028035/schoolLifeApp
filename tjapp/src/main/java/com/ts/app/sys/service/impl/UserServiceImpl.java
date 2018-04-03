package com.ts.app.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.app.sys.dao.UserMapper;
import com.ts.app.sys.domain.User;
import com.ts.app.sys.service.UserService;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<User> findUserList(User user) {
		return userMapper.findUserList(user);
	}
}
