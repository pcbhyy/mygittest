package com.neu.dao;

import com.neu.entity.User;

public interface UserDao {
	public int insert(User user) throws Exception;
	
	public int delete(int id) throws Exception;
}
