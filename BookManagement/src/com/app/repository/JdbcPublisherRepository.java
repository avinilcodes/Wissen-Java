package com.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.db.SQLConnectionFactory;
import com.app.model.Book;
import com.app.model.Publisher;

public class JdbcPublisherRepository implements PublisherRepository {

	@Override
	public void save(Publisher publisher) {
		Connection connection = null;
		try {
			connection = SQLConnectionFactory.getConnection();
//			System.out.println("in publisher :: save");
			String sql = "insert into publisher values(?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, publisher.getId());
			ps.setString(2, publisher.getName());
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

	

	@Override
	public List<Book> findById(int id) {
		Connection connection = null;
		List<Book> books = new ArrayList<>();
		try {
			connection = SQLConnectionFactory.getConnection();

			String sql = "select b.price,p.id,b.pid,b.isbn,b.title from publisher p,book b where p.id=b.pid";
			PreparedStatement ps = connection.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getInt("isbn"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getDouble("price"));
				book.setPid(rs.getInt("pid"));
				books.add(book);
			}
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
		return books;
	}

}
