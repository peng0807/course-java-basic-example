package chapter3.example3_5.p3;


public class TestPrivateAccess {
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.f_default);
		//System.out.println(a.f_private);	                                // 错误的，无法访问A类的私有成员
	}
}
