package com.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.db.SQLConnectionFactory;
import com.app.model.Book;

public class JdbcBookRepository implements BookRepository{

	@Override
	public void save(Book book) {
		Connection connection = null;
		try {
			connection = SQLConnectionFactory.getConnection();

			String sql = "insert into book values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setDouble(3, book.getPrice());
			ps.setInt(4, book.getPid());
			int count = ps.executeUpdate();
			if (count == 1)
				System.out.println("New record inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
