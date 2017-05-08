package cn.com.yedu.dao;

import cn.com.yedu.pojo.User;

public interface IUserDao {
	
	public User selectByPrimaryKey(int userId);
}
