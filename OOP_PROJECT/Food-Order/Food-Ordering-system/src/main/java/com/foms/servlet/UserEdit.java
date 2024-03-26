package com.foms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foms.dao.UserDAO;
import com.foms.db.DBConnection;
import com.foms.entity.User;

@WebServlet("/userEdit")
public class UserEdit extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

	
			String fullName = req.getParameter("fullName");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
	
			int id = Integer.parseInt(req.getParameter("chefId"));

			User user = new User(fullName, email,password );
			
			

			UserDAO userDAO = new UserDAO(DBConnection.getConn());

			boolean f = userDAO.updateUser(user);

			HttpSession session = req.getSession();

			if (f == true) {
				User updateUserObj = userDAO.getUserById(id);
				session.setAttribute("successMsgForD", "User update Successfully");
				session.setAttribute("userObj", updateUserObj); 
				resp.sendRedirect("chef/edit_profile.jsp");

			} else {
				session.setAttribute("errorMsgForD", "Something went wrong on server!");
				resp.sendRedirect("doctor/edit_profile.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
