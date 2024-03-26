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

@WebServlet("/chefEditProfile")
public class ChefEditProfileServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			
			String fullName = req.getParameter("fullName");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String phone = req.getParameter("phone");
			String category = req.getParameter("category");
			int id = Integer.parseInt(req.getParameter("chefId"));

			Chef chef = new Chef(fullName, email,password, phone, category );
			
			

			ChefDAO chefDAO = new ChefDAO(DBConnection.getConn());

			boolean f = chefDAO.editChefProfile(chef);

			HttpSession session = req.getSession();

			if (f == true) {
				Chef updateChefObj = chefDAO.getChefById(id);
				session.setAttribute("successMsgForD", "Chef update Successfully");
				session.setAttribute("chefObj", updateChefObj); 
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
