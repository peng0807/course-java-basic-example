package chapter3.example3_1;

class Person {
	int age;
	String name;
	public Person(int age, String name) {
		this.name = name;
		this.age = age;	
	}
	void printInfo() {
		System.out.println("姓名是：" + this.name);
		System.out.println("年龄是：" + this.age);
	}
}

class Student extends Person {	// 使用“extends”，继承父类Person
	String school;	// 子类新增成员变量
	public Student(int age, String name, String school) {
		super(age, name);	// 使用“super(参数列表)”，调用父类构造方法，必须写在第1行。
//		this.age = age;
//		this.school = school;
		this.school = school;
	}
	void printSchool() {	//	子类新增成员方法：
		System.out.println("学校是："+ this.school);
	}
}

public class TestExtends {
	public static void main(String[] args) {
		Student s1 = new Student(20, "张三", "电子科技大学中山学院");
		Student s2 = new Student(25, "张三", "社会大学");
		s1.printInfo();
		s2.printSchool();
	}
}

