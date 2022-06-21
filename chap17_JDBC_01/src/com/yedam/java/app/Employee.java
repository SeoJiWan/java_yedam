package com.yedam.java.app;

public class Employee {
	
	public String name;
	public int deptId;
	public int salary;
	
	
	/**
	 * @param name
	 * @param empId
	 * @param salary
	 */
	public Employee(String name, int deptId, int salary) {
		this.name = name;
		this.deptId = deptId;
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [ name = " + name + ", deptId = " + deptId + ", salary = " + salary + "]";
	}
	
	
}
