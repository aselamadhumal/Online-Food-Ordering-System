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

@WebServlet("/deleteChef")
public class DeleteChefServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		ChefDAO chefDAO = new ChefDAO(DBConnection.getConn());
		HttpSession session = req.getSession();
		
		boolean f = chefDAO.deleteChefById(id);
		
		if(f==true) {
			session.setAttribute("successMsg", "Chef Deleted Successfully.");
			resp.sendRedirect("chef/view_chef.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Something went wrong on server!");
			resp.sendRedirect("chef/view_chef.jsp");
		}
	}
	
	

}
