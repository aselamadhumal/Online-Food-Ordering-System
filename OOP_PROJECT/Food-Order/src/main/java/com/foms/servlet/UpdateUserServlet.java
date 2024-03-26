package com.foms.servlet;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.foms.dao.UserDAO;
import com.foms.db.DBConnection;
import com.foms.entity.User;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
		
			String fullName = req.getParameter("fullName");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
		
			int id = Integer.parseInt(req.getParameter("id"));

			User user = new User(id, fullName, email,password);

			UserDAO userDAO = new UserDAO(DBConnection.getConn());

			boolean f = userDAO.updateUser(user);

			HttpSession session = req.getSession();

			if (f == true) {
				session.setAttribute("successMsg", "Usr update Successfully");
				resp.sendRedirect("index.jsp");

			} else {
				session.setAttribute("errorMsg", "Something went wrong on server!");
				resp.sendRedirect("user_view.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
