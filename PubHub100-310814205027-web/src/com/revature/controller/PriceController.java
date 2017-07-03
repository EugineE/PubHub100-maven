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



@WebServlet("/PriceController")
public class PriceController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name=request.getParameter("name");
	String price=request.getParameter("price");
	Book book=new Book();
	book.setName(name);
	book.setPrice(Float.parseFloat(price));
	BookDAO dao=new BookDAO();
	try {
		dao.changePrice(book);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("price.jsp");
		request.setAttribute("flag", "true");
		requestDispatcher.forward(request, response);
	} catch (ClassNotFoundException | SQLException e) {
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("price.jsp");
		request.setAttribute("flag", "false");
		requestDispatcher.forward(request, response);
	}
	}


}
