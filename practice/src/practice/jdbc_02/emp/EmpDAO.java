package practice.jdbc_02.emp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmpDAO {

	/*
	 * 필드
	 */
	private static EmpDAO empDAO = null;
	// db properties;
	String conn_driver;
	String conn_url;
	String conn_id;
	String conn_pwd;
	// 메서드 공통 사용 필드
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	/*
	 * 생성자
	 */
	private EmpDAO() {
	}

	/*
	 * 메서드
	 */
	public static EmpDAO getEmpDAO() {
		if (empDAO == null) {
			empDAO = new EmpDAO();
		}
		return empDAO;
	}

	// DB 연동
	public void dbConnect() {
		Properties properties = new Properties();
		String src = "C:\\Users\\Wana\\dev\\workSpace\\eclipse-workspace\\" + "java_yedam\\practice\\src\\practice\\"
				+ "jdbc_02\\config\\db.properties";
		try {
			InputStream path = new FileInputStream(src);
			properties.load(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		conn_driver = properties.getProperty("driver");
		conn_url = properties.getProperty("url");
		conn_id = properties.getProperty("id");
		conn_pwd = properties.getProperty("pwd");
	}

	// DB 연결
	public void connect() {
		dbConnect();

		try {
			Class.forName(conn_driver);
			conn = DriverManager.getConnection(conn_url, conn_id, conn_pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 전체 조회
	public List<Employee> selectAll() {
		connect();

		List<Employee> list = new ArrayList<Employee>();

		try {
			pstmt = conn.prepareStatement("SELECT * FROM employees");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setPhoneNumber(rs.getString(5));
				emp.setHierDate(rs.getDate(6));
				emp.setJobId(rs.getString(7));
				emp.setSalary(rs.getDouble(8));
				emp.setCommissionPCT(rs.getDouble(9));
				emp.setManagerId(rs.getInt(10));
				emp.setDepartmentId(rs.getInt(11));

				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 단일 조회
	public Employee selectOne(int employeeId) {
		connect();
		
		Employee emp = null;
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM employees WHERE employee_id = ?");
			pstmt.setInt(1, employeeId);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setPhoneNumber(rs.getString(5));
				emp.setHierDate(rs.getDate(6));
				emp.setJobId(rs.getString(7));
				emp.setSalary(rs.getDouble(8));
				emp.setCommissionPCT(rs.getDouble(9));
				emp.setManagerId(rs.getInt(10));
				emp.setDepartmentId(rs.getInt(11));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return emp;
	}
	
	// 삽입
	public void insert(Employee emp) {
		connect();
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, emp.getEmployeeId()); 
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
			
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				System.out.println(rs + "행이 삽입되었습니다.");
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
	public void update(Employee emp) {
		connect();
		
		try {
			pstmt = conn.prepareStatement("UPDATE employees SET salary = ? WHERE employee_id = ?");
			pstmt.setDouble(1, emp.getSalary());
			pstmt.setInt(2, emp.getEmployeeId());
			
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				System.out.println(rs + "행이 수정되었습니다.");
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
	public void delete(Employee emp) {
		connect();
		
		try {
			pstmt = conn.prepareStatement("DELETE FROM employees WHERE employee_id = ?");
			pstmt.setInt(1, emp.getEmployeeId());
			
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				System.out.println(rs + "행이 삭제되었습니다.");
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
	
	// DB 연결 해제
	public void disconnect() {

		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
