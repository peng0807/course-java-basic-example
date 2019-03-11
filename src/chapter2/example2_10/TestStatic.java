package chapter2.example2_10;

class Person {
	int age;
	static int count;	// 静态成员变量，用于存放创建的Person对象数量
	static {	// 静态代码块，只会执行一次
		count = 0;	// 初始化静态成员变量
		printCount();	// 可以调用静态成员方法
	}
	public Person(int age) {
		count ++;		// 每次创建对象，调用构造方法时，count值加1
		this.age = age;	
	}
	void printAge() {
		System.out.println("年龄是：" + this.age);
	}
	static void printCount() {	// 静态成员方法中可以访问静态成员变量
		System.out.println("目前总人数是：" + count);	
	}
}

public class TestStatic {
	public static void main(String[] args) {
		Person p1 = new Person(20);
		Person p2 = new Person(30);
		p1.printAge();
		p2.printAge();
		Person.printCount();		// 用“类名.方法名()”来访问静态方法
		System.out.println(Person.count); // 用“类名.属性名”来访问静态属性
	}
}

