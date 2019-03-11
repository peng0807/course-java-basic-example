package chapter2.example2_8;

public class Person {
	int age;
	String name;
	public Person(int age) {
		this.age = age;	// “this.age”是成员变量age, “age”是方法形参age
	}
	public Person(int age, String name) {
		this(age);	// 调用构造方法Person(int age)，这条语句不能写成：Person(age);
		this.name = name;	// “this.name”是成员变量name, “name”是方法形参name
	}
	public void printInfo() {
		System.out.println(this.name + "的年龄是" + this.age);
	}
	public static void main(String[] args) {
		Person p1 = new Person(20, "张三");
		p1.printInfo();	// 此时方法调用中，方法printInfo()中的this = p1
		Person p2 = new Person(30,"李四");
		p2.printInfo();	// 此时方法调用中，方法printInfo()中的this = p2
	}
}
