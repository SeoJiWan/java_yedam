package com.yedam.java.map;

public class Person {
	
	public int age;
	public String name;
	
	
	/**
	 * @param age
	 * @param name
	 */
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	
	// 오버라이딩 메서드
	@Override
	public int hashCode() {
		return this.age + name.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person person = (Person) obj;
			return person.age == this.age && person.name.equals(this.name);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	
	
	
	
	
	

}
