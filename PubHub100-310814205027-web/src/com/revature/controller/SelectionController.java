package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.BookDAO;
import com.revature.model.Book;

/**
 * Servlet implementation class SelectionController
 */
@WebServlet("/SelectionController")
public class SelectionController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data=request.getParameter("search");
		BookDAO bookDAO=new BookDAO();
		try {
			List<Book> list=bookDAO.findByName(data);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
