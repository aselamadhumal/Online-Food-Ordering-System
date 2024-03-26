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

@WebServlet("/updateChef")
public class UpdateChefServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			
			String fullName = req.getParameter("fullName");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String phone = req.getParameter("phone");
			String category = req.getParameter("category");
			
			
			int id = Integer.parseInt(req.getParameter("id"));

			Chef chef = new Chef(id, fullName, email,password, phone, category);

			ChefDAO chefDAO = new ChefDAO(DBConnection.getConn());

			boolean f = chefDAO.updateChef(chef);

			HttpSession session = req.getSession();

			if (f == true) {
				session.setAttribute("successMsg", "Chef update Successfully");
				resp.sendRedirect("chef/view_chef.jsp");

			} else {
				session.setAttribute("errorMsg", "Something went wrong on server!");
				resp.sendRedirect("chef/view_chef.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
