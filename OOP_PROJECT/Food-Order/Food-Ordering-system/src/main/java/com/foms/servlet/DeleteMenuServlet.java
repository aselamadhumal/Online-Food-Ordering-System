package com.foms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foms.dao.MenuDAO;
import com.foms.db.DBConnection;

@WebServlet("/deleteMenu")
public class DeleteMenuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		int id = Integer.parseInt(req.getParameter("id"));
		
		MenuDAO menuDAO = new MenuDAO(DBConnection.getConn());
		HttpSession session = req.getSession();
		
		boolean f = menuDAO.deleteMenuById(id);
		
		if(f==true) {
			session.setAttribute("successMsg", "Menu Deleted Successfully.");
			resp.sendRedirect("menu/view_menu.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Something went wrong on server!");
			resp.sendRedirect("menu/view_menu.jsp");
		}
	}
	
	

}
