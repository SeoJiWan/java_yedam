package com.yedam.java.map;

public class Student {
	
	public int sNo;
	public String name;
	
	
	/**
	 * @param sNo
	 * @param name
	 */
	public Student(int sNo, String name) {
		this.sNo = sNo;
		this.name = name;
	}

	@Override
	public int hashCode() {
		
		return sNo + name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student student = (Student) obj;
			if (student.sNo == this.sNo && student.name.equals(this.name)) {
				return true;
			}
		}
		return false;
	}
}
