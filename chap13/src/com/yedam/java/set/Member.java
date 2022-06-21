package com.yedam.java.set;

public class Member {
	
	public String name;
	public int age;
	
	
	/**
	 * @param name
	 * @param age
	 */
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}


	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member m = (Member) obj;
			return name.equals(m.name) && (age == m.age);
		}
		else {
			return false;
		}
	}
	
	
	
	
	
	
	
	

}
