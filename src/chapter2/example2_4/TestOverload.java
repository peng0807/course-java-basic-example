package chapter2.example2_4;

public class TestOverload {
	static int max(int x, int y) { // static是修饰符，int是返回值类型
		System.out.println("方法签名：max(int,int)");
		return (x > y) ? x : y;
	}

	static int max(int x, int y, int z) { // max是方法名，int x, ...是形参列表
		System.out.println("方法签名：max(int,int,int)");
		if (x > y) {
			return (x > z) ? x : z;
		} else {
			return (y > z) ? y : z;
		}
	}

	static double max(double x, double y) {
		System.out.println("方法签名：max(double,double)");
		return (x > y) ? x : y;
	}

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = 30;
		int max1 = max(a, b); // a、b是实参，方法调用时会将“实参的值”赋给形参。
		int max2 = max(a, b, c); // 会根据实参的类型和数量调用正确的方法
		double d1 = 10.1;
		double d2 = 10.2;
		double d3 = max(d1, d2); // 实参是(double,double)，所以会调用max(double,double)
		System.out.println(max1);
		System.out.println(max2);
		System.out.println(d3);
	}
}
