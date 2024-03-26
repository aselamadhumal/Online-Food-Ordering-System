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
import com.foms.entity.Menu;


@WebServlet("/addMenu")
public class AddMenuServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String foodName = req.getParameter("foodName");
			String price = req.getParameter("price");
			String description = req.getParameter("description");
			
			
			
			Menu menu = new Menu(foodName, price,description);
			System.out.println(menu);
			
			
			MenuDAO menuDAO = new MenuDAO(DBConnection.getConn());
			
			
			boolean f = menuDAO.addMenu(menu);
			
			

			HttpSession session = req.getSession();
			
			if(f==true) {				
				session.setAttribute("successMsg", "Menu added Successfully");
				resp.sendRedirect("menu/view_menu.jsp");
				
			}
			else {
				session.setAttribute("errorMsg", "Something went wrong on server!");
				resp.sendRedirect("menu/add_menu.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
