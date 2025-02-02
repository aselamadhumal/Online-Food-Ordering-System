package com.foms.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.foms.db.DBConnection;
/**
 * Servlet implementation class User_delete
 */

public class User_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		int i = 0;
		
		int id = Integer.parseInt(req.getParameter("id"));

		try {
				String sql = "DELETE FROM user_details WHERE id=?";
				
				PreparedStatement stmt = DBConnection.getConn().prepareStatement(sql);
				stmt.setInt(1, id);

				i = stmt.executeUpdate();
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (i >= 1) {
			
			response.sendRedirect("index.jsp");
			
		}

	}


}
