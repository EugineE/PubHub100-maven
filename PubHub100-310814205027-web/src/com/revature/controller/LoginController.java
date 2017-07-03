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
import javax.servlet.http.HttpSession;

import com.revature.dao.BookDAO;
import com.revature.dao.UserDAO;
import com.revature.model.Book;
import com.revature.model.User;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		UserDAO userDAO=new UserDAO();
		try {
			String flag=userDAO.login(user);
			if(flag.equals("false")){
				RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
				request.setAttribute("flag", flag);
				dispatcher.forward(request, response);
			}
			else
			{
				HttpSession session=request.getSession();
				BookDAO bookDAO=new BookDAO();
				List<Book> list=bookDAO.findAll();
				session.setAttribute("name", flag);
				RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
				request.setAttribute("list", list);
				rd.forward(request, response);	
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
