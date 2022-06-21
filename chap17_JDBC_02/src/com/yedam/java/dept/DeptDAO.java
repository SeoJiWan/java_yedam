package com.yedam.java.dept;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.yedam.java.emp.Employee;

public class DeptDAO {

	/*
	 * 필드
	 */
	// 싱글톤
	private static DeptDAO dao = null;
	// DB connection config
	String conn_driver;
	String conn_url;
	String conn_id;
	String conn_pwd;
	// 메서드에서 공용으로 쓸 필드
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	/*
	 * 생성자
	 */
	private DeptDAO() {
	}

	/*
	 * 메서드
	 */
	// 싱글톤 - 메서드로 인스턴스 생성
	public static DeptDAO getDeptDAO() {
		if (dao == null) {
			dao = new DeptDAO();
		}
		return dao;
	}

	// DB config
	public void dbConfig() {
		String src = "config/db.properties";
		Properties properties = new Properties();

		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(src).getPath();
			properties.load(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		conn_driver = properties.getProperty("driver");
		conn_url = properties.getProperty("url");
		conn_id = properties.getProperty("id");
		conn_pwd = properties.getProperty("pwd");
	}

	// DB connect
	public void connect() {
		dbConfig();

		try {
			Class.forName(conn_driver);
			conn = DriverManager.getConnection(conn_url, conn_id, conn_pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DB disconnect
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 단건 조회
	public Department selectOne(int departmentId) {
		connect();
		
		Department dept = new Department();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM departments WHERE department_id = ?");
			pstmt.setInt(1, departmentId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				dept.setDepartmentId(departmentId);
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return dept;
	}
	
	// 전체 조회
	public List<Department> selectAll() {
		connect();
		
		List<Department> list = new ArrayList<Department>();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM departments");
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Department dept = new Department();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
				
				list.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	// 삽입
	public void insert(Department dept) {
		connect();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO departments VALUES (?, ?, ?, ?)");
			pstmt.setInt(1, dept.getDepartmentId());
			pstmt.setString(2, dept.getDepartmentName());
			pstmt.setInt(3, dept.getManagerId());
			pstmt.setInt(4, dept.getLocationId());
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println(result + "행이 삽입되었습니다.");
			}
			else {
				System.out.println("삽입되지 않았습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 수정
	public void update(Department dept) {
		connect();
		
		try {
			pstmt = conn.prepareStatement("UPDATE departments SET location_id = ? WHERE department_id = ?");
			pstmt.setInt(1, dept.getLocationId());
			pstmt.setInt(2, dept.getDepartmentId());
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println(result + "행이 수정되었습니다.");
			}
			else {
				System.out.println("수정되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 삭제
	public void delete(int departmentId) {
		connect();
		
		try {
			pstmt = conn.prepareStatement("DELETE FROM departments WHERE department_id = ?");
			pstmt.setInt(1, departmentId);
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println(result + "행이 삭제되었습니다.");
			}
			else {
				System.out.println("삭제되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	

}
