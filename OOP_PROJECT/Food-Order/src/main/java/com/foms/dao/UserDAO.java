package com.foms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.foms.entity.Menu;
import com.foms.entity.User;

public class UserDAO {

	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean userRegister(User user) {

		boolean f = false;

		try {
			
			String sql = "insert into user_details(full_name, email, password) values(?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getFullName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());

			pstmt.executeUpdate();

			f = true; 

		} catch (Exception e) {
			e.printStackTrace();

		}

		return f;
	}

	
	public User loginUser(String email, String password) {

		User user = null;

		try {
			String sql = "select * from user_details where email=? and password=?";

			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
		
				user = new User();

			
				user.setId(resultSet.getInt("id"));
				user.setFullName(resultSet.getString("full_name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;

	}

	
	public boolean checkOldPassword(int userId, String oldPassword) {

		boolean f = false;

		try {

			String sql = "select * from user_details where id=? and password=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setString(2, oldPassword);

			ResultSet resultSet = pstmt.executeQuery();
			//System.out.println(resultSet);
			while (resultSet.next()) {
				f = true;
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	//change password
	public boolean changePassword(int userId, String newPassword) {

		boolean f = false;

		try {

			String sql = "update user_details set password=? where id=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setInt(2, userId);

			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	public boolean updateUser(User user) {

		boolean f = false;

		try {

			String sql = "update user_details set full_name=?,email=?,password=? where id=?";

			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, user.getFullName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			
			// need to set id also for update
			pstmt.setInt(4, user.getId());

			pstmt.executeUpdate();
			// if query updated or all ok than
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	public User getUserById(int id) {

		User user = null;

		try {

			String sql = "select * from user_details where id=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet resultSet = pstmt.executeQuery();
			

			while (resultSet.next()) {
				user = new User();

				user.setId(resultSet.getInt("id"));
				user.setFullName(resultSet.getString("full_name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
