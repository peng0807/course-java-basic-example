package chapter2.example2_5;

public class TestConstrutor {
	public static void main(String[] args) {
		int i = 20;
		Person p1 = new Person();	// 调用无参构造方法，初始化新建对象。
		p1.age = i;
		Person p2 = new Person(21);	// 调用有参构造方法，初始化新建对象。
		p1.printAge();	// 调用p1的成员方法printAge()，打印p1的年龄
		p2.printAge();	// 调用p2的成员方法printAge()，打印p2的年龄
	}
}

class Person {
	int age;	// 成员变量：age，年龄
	public Person() {	// 无参的构造方法
		System.out.println("调用构造方法：Person()");
	}
	public Person(int i) {	// 有一个整型参数的构造方法
		age = i;
		System.out.println("调用构造方法：Person(int)");
	}
	void printAge() {	// 成员方法：printAge()，打印年龄信息
		System.out.println("年龄是：" + age + "岁");
	}
}