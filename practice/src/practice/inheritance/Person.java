package practice.inheritance;

public class Person {
	
	public String name;
	public int age;
	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	void introduce() {
		System.out.println("my name is " + this.name + ", " + this.age + " years old.");
	}
	
	void eat() {
		System.out.println("i'm eating.");
	}
	
	
	
	public static void main(String[] args) {
		Person person = new Person("jiwan", 27);
		person.introduce();
		person.eat();
		
		System.out.println();
		
		Student student = new Student("wana", 26, 1);
		student.introduce();
		student.eat();
		student.work();
		
		System.out.println();
		
		Person person2 = new Student("woo", 28, 2);
		person2.introduce();
		person2.eat(); // 부모클래스(Person) 의 모든 메소드 사용 가능, 자식클래스(Student)의 work 메서드 사용불가.
	}
}


class Student extends Person {
	
	public int grade;

	
	public Student(String name, int age, int grade) {
		super(name, age); // 부모 클래스의 생성자 그대로 들고 옴. 추가 및 변경(생성자에 고정 값 대입시) 가능
		this.grade = grade;
	}


	@Override
	void introduce() {
		super.introduce();
		System.out.println("I'm " + this.grade + " grade.");
	}
	
	void work() {
		System.out.println("i study hard");
	}
}