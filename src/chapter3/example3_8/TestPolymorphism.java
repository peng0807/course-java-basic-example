package chapter3.example3_8;

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
public class TestPolymorphism {
	public static void main(String[] args) {
		A a = new B();	 // a的编译时类型是A，a的运行时类型是B
		System.out.println(a.field1);	// 访问成员变量是根据编译时类型决定的
		a.method1();	// 访问成员方法时根据运行时类型决定的
	}
}
