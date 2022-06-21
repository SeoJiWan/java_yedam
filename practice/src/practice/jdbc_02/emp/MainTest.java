package practice.jdbc_02.emp;

import java.sql.Date;
import java.util.List;

public class MainTest {
	
	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setEmployeeId(1000);
		emp.setFirstName("seo");
		emp.setLastName("jiwan");
		emp.setEmail("wana1997");
		emp.setPhoneNumber("0809809809");
		emp.setHierDate(new Date(21, 9, 13));
		emp.setJobId("AD_ASST");
		emp.setSalary(9999);
		emp.setCommissionPCT(0.2);
		emp.setManagerId(101);
		emp.setDepartmentId(110);
		
		Employee emp2 = new Employee();
		emp2.setEmployeeId(1000);
		emp2.setFirstName("seo");
		emp2.setLastName("jiwan");
		emp2.setEmail("wana1997");
		emp2.setPhoneNumber("0809809809");
		emp2.setHierDate(new Date(21, 9, 13));
		emp2.setJobId("AD_ASST");
		emp2.setSalary(7777);
		emp2.setCommissionPCT(0.2);
		emp2.setManagerId(101);
		emp2.setDepartmentId(110);
		
		
		List<Employee> selectAll = EmpDAO.getEmpDAO().selectAll();
		selectAll.forEach(System.out::println);
		
		System.out.println();
		
		Employee selectOne = EmpDAO.getEmpDAO().selectOne(100);
		System.out.println(selectOne);
		
		EmpDAO.getEmpDAO().insert(emp);
		
		EmpDAO.getEmpDAO().update(emp2);
		
		EmpDAO.getEmpDAO().delete(emp2);
		
		
	}

}
