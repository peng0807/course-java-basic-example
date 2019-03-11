package chapter2.example2_9;

public class Person {
	int age;
	static int count;	// 静态成员变量，用于存放创建的对象数量
	public Person(int age) {
		count ++;		// 每次创建对象，调用构造方法时，count值加1
		this.age = age;	
	}
	public static void main(String[] args) {
		Person p1 = new Person(20);
		Person p2 = new Person(30);
		System.out.println("总共创建的Person对象数量是：" + count);
//		System.out.println(age);
		System.out.println(p1.age);
		System.out.println(p2.age);
	}
}
