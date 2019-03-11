package chapter3.example3_4;

class T { // 如果定义为final class T，则这个类T不能被继承
	// final的成员变量只能赋值一次，要么在定义时赋值，要么在构造方法中赋值
	final int i;	// 如果定义为final int i = 5，则不能在构造方法中赋值
	final static int i_s = 5; // final的静态成员变量不能在构造方法里初始化
	public T() {
		i = 10;
	}
	final void m(final int j) { // final的方法不能被重写override
		// j++; // 错误，不能修改局部常量j的值
		final int k = 9;
		// k++; // 错误，不能修改局部常量k的值
		System.out.println(k);
	}
}
class TT extends T {
	void m() {		// 如果定义为void m(int j)，则会出错
		System.out.println("这不是方法的覆盖");
	}
}
public class TestFinal {
	public static void main(String[] args) {
		T t = new T();
		// t.i = 8; // 错误，不能修改成员常量i的值
		System.out.println(t.i);
	}
}
