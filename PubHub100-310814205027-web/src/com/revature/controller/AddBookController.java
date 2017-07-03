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
import com.revature.model.Book;


@WebServlet("/AddBookController")
public class AddBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String authorName=request.getParameter("authorName");
		Book book = new Book();
		book.setAuthorName(authorName);
		book.setPrice(Float.parseFloat(price));
		book.setName(name);
		BookDAO bookDAO=new BookDAO();
		try {
			bookDAO.add(book);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			RequestDispatcher dispatcher=request.getRequestDispatcher("addBook.jsp");
			request.setAttribute("flag", "false");
			dispatcher.forward(request, response);
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("addBook.jsp");
		request.setAttribute("flag", "true");
		dispatcher.forward(request, response);
	}

}
