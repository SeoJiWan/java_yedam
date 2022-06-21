package com.yedam.java.app;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SelectEx {
	
	public static void main(String[] args) throws Exception {
		
		// JDBC 사용 방법
		// 1. JDBC driver 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. DB 서버 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		Connection con = DriverManager.getConnection(url, id, pwd);
		
		// 3. Statement or PreparedStatement 객체 생성 
		Statement stmt = con.createStatement();
		
		// 4. Query 구성
		String sql = "select * from employees"; // 세미콜론 생략
		
		// 5. Query 실행
		ResultSet rs = stmt.executeQuery(sql);
		
		
		Map<Integer, Employee> emp = new HashMap<Integer, Employee>();
		// 6. 결과값 출력
		while (rs.next()) {
			int empId = rs.getInt("employee_id");
			String name = rs.getString("first_name") + " " + rs.getString("last_name");
			int deptId = rs.getInt("department_id");
			int salary = rs.getInt("salary");
			
			emp.put(empId, new Employee(name, deptId, salary));
			
//			System.out.println("employe_id : " + empId + "\tname : " + name + "\t\tsalary : " + salary);
		}
		
		// 7. 사용한 자원 해제
		rs.close();
		stmt.close();
		con.close();
		
		System.out.println();
		
		for (Map.Entry<Integer, Employee> entry : emp.entrySet()) {
			Integer key = entry.getKey();
			Employee val = entry.getValue();
			
			System.out.println("id : " + key + ", "+ val);
			
		}
		
	}

}
