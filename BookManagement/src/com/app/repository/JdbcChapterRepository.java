package com.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.db.SQLConnectionFactory;
import com.app.model.Chapter;

public class JdbcChapterRepository implements ChapterRepository {

	@Override
	public void save(Chapter chapter) {
		Connection connection = null;
		try {
			connection = SQLConnectionFactory.getConnection();

			String sql = "insert into chapter values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, chapter.getIdx());
			ps.setString(2, chapter.getTitle());
			ps.setInt(3, chapter.getPages());
			ps.setInt(4, chapter.getBookIsbn());
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
