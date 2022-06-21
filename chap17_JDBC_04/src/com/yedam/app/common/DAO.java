package com.yedam.app.common;

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
	// field for DB connect
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	// field for DB configuration
	private String cDriver;
	private String cUrl;
	private String cId;
	private String cPwd;


	/*
	 * Method
	 */
	// DB configuration
	public void dbConfig() {
		String src = "config/db.properties"; // src폴더 아래부터의 경로
		Properties properties = new Properties();

		try {
			String path = ClassLoader.getSystemClassLoader().getResource(src).getPath();
			properties.load(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		cDriver = properties.getProperty("driver");
		cUrl = properties.getProperty("url");
		cId = properties.getProperty("id");
		cPwd = properties.getProperty("pwd");
	}

	// DB connect
	public void connect() {
		dbConfig();
		
		try {
			Class.forName(cDriver);
			conn = DriverManager.getConnection(cUrl, cId, cPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// DB disconnect
	public void disconnect() {

		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}