package com.app.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnectionFactory {
	
	private static Properties properties = new Properties();
	static {
		try {
			FileInputStream fis = new FileInputStream("db.properties");
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		try {
//			//Class.forName(properties.getProperty("db.driver"));
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}

	public static Connection getConnection() throws SQLException {
		String url = (String) properties.getProperty("db.url");
		String user = properties.getProperty("db.user");
		String password = properties.getProperty("db.password");
		return DriverManager.getConnection(url, user, password);
	}

}
