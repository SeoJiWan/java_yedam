package practice.jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectEx {
	
	public static void main(String[] args) throws Exception {
		
		// 1. JDBC driver 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. DB server 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		// 3. Statement or PreparedStatement 객체 생성
		Statement stmt = conn.createStatement();
		
		// 4. Query 구성
		String sql = "SELECT * FROM employees ORDER BY employee_id";
		
		// 5. Query 실행
		ResultSet rs = stmt.executeQuery(sql);
		
		// 6. 결과값 출력
		while (rs.next()) {
			int empId = rs.getInt("employee_id");
			String name = rs.getString("first_name") + " " + rs.getString("last_name");
			double salary = rs.getDouble("salary");
			int deptId = rs.getInt("department_id");
			
			System.out.println(empId + "\t\t" + name + "\t\t" + salary + "\t\t" + deptId);
		}
		
		// 7. 자원 해제
		rs.close();
		stmt.close();
		conn.close();
		
	}

}
