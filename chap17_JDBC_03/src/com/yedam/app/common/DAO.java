package com.yedam.app.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAO {

	/*
	 * 필드
	 */
	// Oracle 연결 정보
	private String jdbc_driver;
	private String oracle_url;
	private String connected_id;
	private String connected_pwd;
	// 각 메서드에서 공통적으로 사용하는 필드
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	
	/*
	 * 메서드
	 */
	// DB 정보설정 - config / db.properties 의 정보 설정
	public void dbConfig() {
		String src = "config/db.properties";
		Properties properties = new Properties();

		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(src).getPath();
			properties.load(new FileInputStream(filePath));
//					InputStream filePath = new FileInputStream("C:/Users/Wana/dev/workSpace/eclipse-workspace/java_yedam/chap17_JDBC_02/src/config/db.properties");
//					properties.load(filePath);

		} catch (IOException e) {
			e.printStackTrace();
		}

		jdbc_driver = properties.getProperty("driver");
		oracle_url = properties.getProperty("url");
		connected_id = properties.getProperty("id");
		connected_pwd = properties.getProperty("pwd");
	}

	// DB 연결
	public void connect() {
		dbConfig();

		try {
			// 1. JDBC Driver 로딩
			Class.forName(jdbc_driver);
			// 2. DB Server 접속
			conn = DriverManager.getConnection(oracle_url, connected_id, connected_pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}

	}

	// DB 연결 해제
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
