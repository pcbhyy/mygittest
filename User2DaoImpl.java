package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.neu.entity.User2;
import com.neu.util.ServiceException;

public class User2DaoImpl implements User2Dao {
	private Connection connection;
	public User2DaoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public int updatePassword(User2 user) {
		String sql = "update tab_user2 set password = ? where username = ? and password = ?";
		int n = 0;
		try {
			PreparedStatement s = connection.prepareStatement(sql);
			s.setString(1, user.getNewPasworld());
			s.setString(2, user.getUsername());
			s.setString(3, user.getPassword());
			
			n = s.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new ServiceException();
		}
		
		return n;
	}

}
