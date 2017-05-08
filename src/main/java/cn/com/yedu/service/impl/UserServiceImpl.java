package cn.com.yedu.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yedu.dao.IUserDao;
import cn.com.yedu.pojo.User;
import cn.com.yedu.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;

	
	@Override
	public User getUserById(int userId) {
		return userDao.selectByPrimaryKey(userId);
	}

}
