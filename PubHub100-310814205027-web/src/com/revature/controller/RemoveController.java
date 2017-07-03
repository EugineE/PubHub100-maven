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


@WebServlet("/RemoveController")
public class RemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		BookDAO bookDAO = new BookDAO();
		try {
			bookDAO.remove(name);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("remove.jsp");
			request.setAttribute("flag", "true");
			requestDispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("remove.jsp");
			request.setAttribute("flag", "false");
			requestDispatcher.forward(request, response);
		}
	}

	

}
