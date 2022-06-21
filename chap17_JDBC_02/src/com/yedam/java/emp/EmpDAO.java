package com.yedam.java.emp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
 * 실제로 DB에 접근하는 객체다. 
 * DAO는 프로젝트의 서비스 모델과 실제 데이터베이스를 연결하는 역할
 * 싱글톤으로 구현하는 것이 좋음
 */
public class EmpDAO {

	/*
	 * 필드
	 */
	// 싱글톤
	private static EmpDAO empDAO = null; 
	// Oracle 연결 정보
	String jdbc_driver;
	String oracle_url;
	String connected_id;
	String connected_pwd;
	// 각 메서드에서 공통적으로 사용하는 필드
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	
	/*
	 * 생성자
	 */
	// 싱글톤으로 생성 -> private
	private EmpDAO() { 

	}

	
	/*
	 * 메서드
	 */
	// 싱글톤이므로 메서드를 활용해 객체 생성
	public static EmpDAO getEmpDAO() { 
		if (empDAO == null) {
			empDAO = new EmpDAO();
		}
		return empDAO;
	}
	
	// DB 연결
	public void connect() {
		dbConfig();
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName(jdbc_driver);
			// 2. DB Server 접속
			conn = DriverManager.getConnection(oracle_url, connected_id, connected_pwd);
		}
		catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
		}
		catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}
		
	}
	
	// DB 정보설정 - config / db.properties 의 정보 설정
	private void dbConfig() {
		String src = "config/db.properties";
		Properties properties = new Properties();
		
		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(src).getPath();
			properties.load(new FileInputStream(filePath));
//			InputStream filePath = new FileInputStream("C:/Users/Wana/dev/workSpace/eclipse-workspace/java_yedam/chap17_JDBC_02/src/config/db.properties");
//			properties.load(filePath);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		jdbc_driver = properties.getProperty("driver");
		oracle_url = properties.getProperty("url");
		connected_id = properties.getProperty("id");
		connected_pwd = properties.getProperty("pwd");
	}
	
	// 3. CRUD 실행
	// 전체조회
	public List<Employee> selectAll() {
		List<Employee> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employees ORDER BY employee_id");
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHierDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPCT(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
				
				list.add(emp);
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			disconnect();
		}
		return list;
	}
	
	// 단건조회
	public Employee selectOne(int employeeId) {
		Employee emp = null;
		try {
			connect();
			String sql = "SELECT * FROM employees WHERE employee_id = " + employeeId;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHierDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPCT(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return emp;
	}
	
	// 등록
	public void insert(Employee emp) {
		try {
			connect();
			pstmt = conn.prepareStatement("INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, emp.getEmployeeId()); // setInt(int parameter(?) idx, int x)
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhoneNumber());
			pstmt.setDate(6, emp.getHierDate());
			pstmt.setString(7, emp.getJobId());
			pstmt.setDouble(8, emp.getSalary());
			pstmt.setDouble(9, emp.getCommissionPCT());
			pstmt.setInt(10, emp.getManagerId());
			pstmt.setInt(11, emp.getDepartmentId());
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("등록이 완료되었습니다.");
			}
			else {
				System.out.println("등록되지 않았습니다.");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
	}
	
	// 수정 - 연봉
	public void update(Employee emp) {
		try {
			connect();
			pstmt = conn.prepareStatement("UPDATE employees SET salary = ? WHERE employee_id = ?");
			pstmt.setDouble(1, emp.getSalary());
			pstmt.setInt(2, emp.getEmployeeId()); // setInt(int parameter(?) idx, int x)
			
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println(result + "행 등록이 완료되었습니다.");
			}
			else {
				System.out.println("수정되지 않았습니다.");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
	}
	
	// 삭제
	public void delete(int employeeId) {
		try {
			connect();
			stmt = conn.createStatement();
			
			int result = stmt.executeUpdate("DELETE FROM employees WHERE employee_id = " + employeeId);
			if (result > 0) {
				System.out.println(result + "행 삭제가 완료되었습니다.");
			}
			else {
				System.out.println("삭제되지 않았습니다.");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			disconnect();
		}
	}
	
	// 4. 자원 해제
	public void disconnect() {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
