package chap07.com.yedam.java.ch0703;

public class AnimalTest {
	
	public static void main(String[] args) {
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		dog.sound();
		cat.sound();
		
		System.out.println();
		
		Animal animal = dog;
		animal.sound();
		animal = cat;
		animal.sound();
	}

}
