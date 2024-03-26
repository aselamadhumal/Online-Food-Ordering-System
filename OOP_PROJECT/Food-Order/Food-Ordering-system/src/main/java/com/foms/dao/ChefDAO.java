package com.foms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.foms.entity.Chef;

public class ChefDAO {

	private Connection conn;

	public ChefDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean registerChef(Chef chef) {

		boolean f = false;

		try {

			String sql = "insert into chef(fullName,email,phone,category,password) values(?,?,?,?,?)";

			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, chef.getFullName());
			pstmt.setString(2, chef.getEmail());
			pstmt.setString(3, chef.getPhone());
			pstmt.setString(4, chef.getCategory());
			pstmt.setString(5, chef.getPassword());

			pstmt.executeUpdate();
		
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}


	public List<Chef> getAllChefs() {

		Chef chef = null;
		List<Chef> chefList = new ArrayList<Chef>();

		try {

			String sql = "select * from chef order by id desc";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				chef = new Chef();

				chef.setId(resultSet.getInt("id"));
				chef.setFullName(resultSet.getString("fullName"));
				chef.setEmail(resultSet.getString("email"));
				chef.setPhone(resultSet.getString("phone"));
				chef.setCategory(resultSet.getString("category"));
				chef.setPassword(resultSet.getString("password"));
				chefList.add(chef);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return chefList;
	}


	public Chef getChefById(int id) {

		Chef chef = null;

		try {

			String sql = "select * from chef where id=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				chef = new Chef();

				chef.setId(resultSet.getInt("id"));
				chef.setFullName(resultSet.getString("fullName"));
				chef.setEmail(resultSet.getString("email"));
				chef.setPhone(resultSet.getString("phone"));
				chef.setCategory(resultSet.getString("category"));
				chef.setPassword(resultSet.getString("password"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return chef;
	}

	
	public boolean updateChef(Chef chef) {

		boolean f = false;

		try {

			String sql = "update chef set fullName=?,email=?,phone=?,category=?,password=? where id=?";

			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, chef.getFullName());
			pstmt.setString(2, chef.getEmail());
			pstmt.setString(3, chef.getPhone());
			pstmt.setString(4, chef.getCategory());
			pstmt.setString(5, chef.getPassword());
			
			pstmt.setInt(6, chef.getId());

			pstmt.executeUpdate();
			
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}


	public boolean deleteChefById(int id) {

		boolean f = false;

		try {

			String sql = "delete from chef where id=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}


	public Chef loginChef(String email, String password) {

		Chef chef = null;

		try {

			String sql = "select * from chef where email=? and password=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				chef = new Chef();

				

				chef.setId(resultSet.getInt(1));
				chef.setFullName(resultSet.getString(2));
				chef.setEmail(resultSet.getString(3));
				chef.setPhone(resultSet.getString(4));
				chef.setPassword(resultSet.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return chef;

	}


	public boolean editChefProfile(Chef chef) {

		boolean f = false;

		try {

			
			String sql = "update chef set fullName=?,email=?,phone=?,category=?,password=? where id=?";

			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, chef.getFullName());
			pstmt.setString(2, chef.getEmail());
			pstmt.setString(3, chef.getPhone());
			pstmt.setString(4, chef.getCategory());
			pstmt.setString(5, chef.getPassword());
			
			pstmt.setInt(6, chef.getId());

			pstmt.executeUpdate();
		
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

}
