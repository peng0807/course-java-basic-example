package chapter2.example2_2;

public class Person {	// 使用关键字class定义类
	int age;	// 成员变量：age，年龄
	void printAge() {	// 成员方法：printAge()，打印年龄信息
		System.out.println("年龄是：" + age + "岁");
	}
	public static void main(String[] args) {
		Person p1 = new Person();	// 创建Person对象p1
		Person p2 = new Person();	// 创建Person对象p2
		int i = 20;
		p1.age = i;	//	设置p1的成员变量age
		p2.age = 21;	// 设置p2的成员变量age
		p1.printAge();	// 调用p1的成员方法printAge()，打印p1的年龄
		p2.printAge();	// 调用p2的成员方法printAge()，打印p2的年龄
	}
}
