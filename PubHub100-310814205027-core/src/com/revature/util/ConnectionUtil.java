package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.transform.sax.SAXTransformerFactory;

public class ConnectionUtil {

	public static Connection getConnection()  {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","0000");
		} 
		
		catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		return connection;
		
	}
}
