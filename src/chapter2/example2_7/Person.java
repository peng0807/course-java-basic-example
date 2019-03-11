package chapter2.example2_7;

public class Person {
	int age = 10;
	Person father;
	public Person(int a) {
		age = a;
	}
	public static void main(String[] args) {
		Person p1 = new Person(20);
		Person p2 = new Person(50);
		p1.father = p2;
		p2.father.age = 80;
	}
}
