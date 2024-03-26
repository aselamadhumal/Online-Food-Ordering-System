package com.foms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foms.dao.ChefDAO;
import com.foms.db.DBConnection;
import com.foms.entity.Chef;


@WebServlet("/chefLogin")
public class ChefLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		
		HttpSession session = req.getSession();

		
		ChefDAO chefDAO = new ChefDAO(DBConnection.getConn());
		
		
		Chef chef = chefDAO.loginChef(email, password);

		if (chef != null) {
		
			session.setAttribute("chefObj", chef);
			
			resp.sendRedirect("menu/view_menu.jsp");
		} else {
			session.setAttribute("errorMsg", "Invalid email or password");
			resp.sendRedirect("chef_login.jsp");
		}

	}

}
