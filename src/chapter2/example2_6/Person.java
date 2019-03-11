package chapter2.example2_6;

public class Person {
	int age = 10;	
	public Person(int a) {	
		age = a;
	}
	public static void main(String[] args) {
		int i = 20;	// 第1行
		Person p1 = new Person(i);	 // 第2行
		Person p2 = p1;	// 第3行
		Person p3 = new Person(30);	// 第4行
		System.out.println(p1 == p2);
		System.out.println(p1 == p3);
	}
}
