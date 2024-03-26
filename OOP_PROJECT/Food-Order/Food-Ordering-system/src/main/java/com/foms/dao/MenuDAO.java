package com.foms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.foms.entity.Menu;

public class MenuDAO {

	private Connection conn;

	public MenuDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addMenu(Menu menu) {

		boolean f = false;

		try {

			String sql = "insert into menu(foodName,price,description) values(?,?,?)";

			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, menu.getFoodName());
			pstmt.setString(2, menu.getPrice());
			pstmt.setString(3, menu.getDescription());

		

			pstmt.executeUpdate();
		
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	
	public List<Menu> getAllMenus() {

		Menu menu = null;
		List<Menu> menuList = new ArrayList<Menu>();

		try {

			String sql = "select * from menu order by id desc";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				menu = new Menu();

				menu.setId(resultSet.getInt("id"));
				menu.setFoodName(resultSet.getString("foodName"));
				menu.setPrice(resultSet.getString("price"));
				menu.setDescription(resultSet.getString("description"));

				
				menuList.add(menu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return menuList;
	}

	
	public Menu getMenuById(int id) {

		Menu menu = null;

		try {

			String sql = "select * from menu where id=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				menu = new Menu();

				menu.setId(resultSet.getInt("id"));
				menu.setFoodName(resultSet.getString("foodName"));
				menu.setPrice(resultSet.getString("price"));
				menu.setDescription(resultSet.getString("description"));

				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return menu;
	}

	
	public boolean updateMenu(Menu menu) {

		boolean f = false;

		try {

			String sql = "update menu set foodName=?,price=?,description=? where id=?";

			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, menu.getFoodName());
			pstmt.setString(2, menu.getPrice());
			pstmt.setString(3, menu.getDescription());

		
			pstmt.setInt(4, menu.getId());

			pstmt.executeUpdate();
	
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	
	public boolean deleteMenuById(int id) {

		boolean f = false;

		try {

			String sql = "delete from menu where id=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}


}
