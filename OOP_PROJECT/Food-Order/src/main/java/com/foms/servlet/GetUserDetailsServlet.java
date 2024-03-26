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

@WebServlet("/getUser")
public class GetUserDetailsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int id = Integer.parseInt(req.getParameter("id"));



			UserDAO userDAO = new UserDAO(DBConnection.getConn());

			User user = userDAO.getUserById(id);

			HttpSession session = req.getSession();

			if (user!=null) {
				session.setAttribute("userObj",user);
				resp.sendRedirect("user_view.jsp"); 
			}
			else {
				session.setAttribute("errorMsg","Invalid email or password");
				resp.sendRedirect("user_login.jsp"); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
