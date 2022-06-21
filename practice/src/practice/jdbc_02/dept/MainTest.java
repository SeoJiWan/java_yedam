package practice.jdbc_02.dept;

import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		
		List<Department> list = DeptDAO.getDeptDAO().selectAll();
		list.forEach(System.out::println);
	}
}
