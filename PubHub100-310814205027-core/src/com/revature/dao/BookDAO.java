package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Book;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class BookDAO {

	public void add(Book book) {
		Connection connection = ConnectionUtil.getConnection();

		String sql = "insert into books (name,price,author_name) values(?,?,?)";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getName());
			preparedStatement.setFloat(2, book.getPrice());
			preparedStatement.setString(3, book.getAuthorName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void changeName(String oldName, String newName) {
		String sql = "update books set name=? where name=?";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, oldName);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void changePrice(Book book) {
		String sql = "update books set price=? where name=?";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setFloat(1, book.getPrice());
			preparedStatement.setString(2, book.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public List<Book> findAll() {
		String sql = "select id,name,price,author_name from books";
		List<Book> list = new ArrayList<Book>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			set = preparedStatement.executeQuery();

			while (set.next()) {
				Book book = new Book();
				book.setId(set.getInt(1));
				book.setName(set.getString(2));
				book.setPrice(set.getInt(3));
				book.setAuthorName(set.getString(4));
				list.add(book);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<Book> findByName(String value) {
		String sql = "select id,name,price,author_name from books where name like ? ";
		value = value.concat("%");
		List<Book> list = new ArrayList<Book>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, value);
			set = preparedStatement.executeQuery();

			while (set.next()) {
				Book book = new Book();
				book.setId(set.getInt(1));
				book.setName(set.getString(2));
				book.setPrice(set.getInt(3));
				book.setAuthorName(set.getString(4));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<Book> findById(int id) {
		String sql = "select name,price,author_name from books where id=? ";
		List<Book> list = new ArrayList<Book>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			set = preparedStatement.executeQuery();

			while (set.next()) {
				Book book = new Book();
				book.setName(set.getString(1));
				book.setPrice(set.getInt(2));
				book.setAuthorName(set.getString(3));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<Integer> getAllId() {
		String sql = "select id from books";
		List<Integer> list = new ArrayList<Integer>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet set = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			set = preparedStatement.executeQuery();
			while (set.next()) {
				list.add(set.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public void remove(String name) {
		String sql = "delete from books where name=?";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
