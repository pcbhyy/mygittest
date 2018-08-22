package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.neu.entity.User;
import com.neu.util.DBUtils;

public class UserDaoImpl implements UserDao {
	private Connection connection;
	public UserDaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int insert(User user) throws Exception {
		String sql = "insert into tab_user values(ids.nextval,?,?,?)";
		
		PreparedStatement s = connection.prepareStatement(sql);
		s.setString(1, user.getRealname());
		s.setString(2, user.getSex());
		s.setString(3, user.getCert());		
		
		int n = s.executeUpdate();			
		
		return n;
	}

	@Override
	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
