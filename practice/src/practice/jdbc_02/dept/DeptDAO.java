package practice.jdbc_02.dept;

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

public class DeptDAO {

	/*
	 * 필드
	 */
	private static DeptDAO dao = null;
	// DB conn
	String cDriver;
	String cUrl;
	String cId;
	String cPwd;
	// Common field
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	/*
	 * 생성자
	 */
	private DeptDAO() {}
	
	
	/*
	 * 메서드
	 */
	// 싱글톤으로 인스턴스 생성
	public static DeptDAO getDeptDAO() {
		if (dao == null) {
			dao = new DeptDAO();
		}
		return dao;
	}
	
	// DB Config
	public void dbConfig() {
		String src = "config/db.properties";
		Properties properties = new Properties();
		
		try {
//			String path = ClassLoader.getSystemClassLoader().getResource(src).getPath();
			String path = "C:\\Users\\Wana\\dev\\workSpace\\"
					+ "eclipse-workspace\\java_yedam\\practice"
					+ "\\src\\practice\\jdbc_02\\config\\db.properties";
			properties.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 삽입
	public void insert(Department dept) {
		try {
			connect();
			String sql = "INSERT INTO departments VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDepartmentId());
			pstmt.setString(2, dept.getDepartmentName());
			pstmt.setInt(3, dept.getManagerId());
			pstmt.setInt(4, dept.getLocationId());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println(result + "행 삽입");
			}
			else {
				System.out.println("삽입 안됨");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 단건조회
	public Department selectOne(int departmentId) {
		Department dept = new Department();
		try {
			connect();
			String sql = "SELECT * FROM departments WHERE department_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, departmentId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dept.setDepartmentId(rs.getInt(1));
				dept.setDepartmentName(rs.getString(2));
				dept.setManagerId(rs.getInt(3));
				dept.setLocationId(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return dept;
	}
	
	// 전체조회
	public List<Department> selectAll() {
		List<Department> list = new ArrayList<Department>();
		try {
			connect();
			String sql = "SELECT * FROM departments";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Department dept = new Department();
				dept.setDepartmentId(rs.getInt(1));
				dept.setDepartmentName(rs.getString(2));
				dept.setManagerId(rs.getInt(3));
				dept.setLocationId(rs.getInt(4));
				
				list.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
