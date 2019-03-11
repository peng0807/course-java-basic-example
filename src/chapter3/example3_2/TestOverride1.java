package chapter3.example3_2;

class A {
	int field1 = 1;
	void method1() {
		System.out.println("A.method1()");
	}
}

class B extends A {
	int field1 = 2;	// 定义和父类A同名的成员变量，变量的隐藏
	void method1() {	// 定义和父类A同名的成员方法，方法的覆盖
		System.out.println("B.method1()");
	}
}

public class TestOverride1 {
	public static void main(String[] args) {
		B b = new B();
		b.method1();
		System.out.println(b.field1);
	}
}
