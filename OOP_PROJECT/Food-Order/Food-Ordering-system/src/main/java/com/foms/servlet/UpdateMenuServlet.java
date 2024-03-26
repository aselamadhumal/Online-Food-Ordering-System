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

import com.foms.dao.MenuDAO;
import com.foms.db.DBConnection;
import com.foms.entity.Menu;

@WebServlet("/updateMenu")
public class UpdateMenuServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
		
			String foodName = req.getParameter("foodName");
			String price = req.getParameter("price");
			String description = req.getParameter("description");
			
			int id = Integer.parseInt(req.getParameter("id"));

			Menu menu = new Menu(id, foodName, price,description);

			MenuDAO menuDAO = new MenuDAO(DBConnection.getConn());

			boolean f = menuDAO.updateMenu(menu);

			HttpSession session = req.getSession();

			if (f == true) {
				session.setAttribute("successMsg", "Menu update Successfully");
				resp.sendRedirect("menu/view_menu.jsp");

			} else {
				session.setAttribute("errorMsg", "Something went wrong on server!");
				resp.sendRedirect("menu/view_menu.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
