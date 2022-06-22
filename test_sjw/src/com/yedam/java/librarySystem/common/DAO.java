package com.yedam.java.librarySystem.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DAO {
	
	/*
	 * Field
	 */
	// DB Configuration
	private String driver;
	private String url;
	private String id;
	private String pwd;
	// common field
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	
	/*
	 * Method
	 */
	// DB Configuration
	private void dbConfig() {
		String src = "com/yedam/java/librarySystem/config/db.properties";
		Properties properties = new Properties();
		
		try {
			String path = ClassLoader.getSystemClassLoader().getResource(src).getPath();
			properties.load(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		id = properties.getProperty("id");
		pwd = properties.getProperty("pwd");
	}
	
	// DB connect
	public void connect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// DB disconnect
	public void disconnect() {
		try {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
