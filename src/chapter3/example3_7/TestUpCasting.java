package chapter3.example3_7;

class A { 
	int field1;
	void method1() {	}
}
class B extends A { 
	int field2;
	void method2() {	}
}
public class TestUpCasting {
	public static void main(String[] args) {
		B b = new B();	// 定义一个子类对象
		A a = b;	// 父类引用指向子类对象，向上转型，可以自动转换
		System.out.println(a.field1);
//		System.out.println(a.field2);	//不能访问子类新增变量
		a.method1();
//		a.method2();	// 不能访问子类新增方法
	}
}
