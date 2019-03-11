package chapter3.example3_3;

class Person {
	int age;
	String name;
	static int count;	// 静态成员变量，用于存放创建的Person对象数量
	public Person(int age, String name) {
		count++;	// 每次创建对象，调用构造方法时，count值加1
		this.name = name;
		this.age = age;
	}
	static void printCount() {	// 静态成员方法中可以访问静态成员变量
		System.out.println("目前总人数是：" + count);	
	}
	void printAge() {	// 打印年龄属性
		System.out.println("年龄是：" + this.age);
	}
	void printName() {	// 打印姓名属性
		System.out.println("姓名是：" + this.name);
	}
	void printInfo() { // 被子类覆盖的成员方法
		printAge();
		printName();
	}
}

class Student extends Person {
	String school;
	public Student(int age, String name, String school) {
		super(age, name);	// 使用“super”，调用父类的构造方法
		this.school = school;
	}
	void printSchool() {
		System.out.println("学校是：" + this.school);
	}
	void printInfo() { // 和父类相同的成员方法，覆盖父类的printInfo()方法
		super.printInfo(); // 使用“super”，调用父类中被覆盖的方法
		printSchool();
	}
}

public class TestOverride2 {
	public static void main(String[] args) {
		Student s = new Student(20, "张三", "电子科技大学中山学院");
		s.printInfo();
	}
}
