package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.BookDAO;


@WebServlet("/RenameController")
public class RenameController extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldName=request.getParameter("oldName");
		String newName=request.getParameter("newName");
		
		BookDAO bookDAO=new BookDAO();
		try {
			bookDAO.changeName(oldName, newName);
		}
		catch (ClassNotFoundException | SQLException e) {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("rename.jsp");
			request.setAttribute("flag", "false");
			requestDispatcher.forward(request, response);
		}
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("rename.jsp");
		request.setAttribute("flag", "true");
		requestDispatcher.forward(request, response);
	}

	
}
