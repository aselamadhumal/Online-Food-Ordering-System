package com.foms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foms.entity.User;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//create one static Admin for this project
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			HttpSession session = req.getSession();
			
			//logic for a static Admin
			if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
				
		
				session.setAttribute("adminObj", new User());
				resp.sendRedirect("chef/view_chef.jsp");
			}
			else {
				session.setAttribute("errorMsg", "Invalid Username or Password.");
				resp.sendRedirect("admin_login.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
