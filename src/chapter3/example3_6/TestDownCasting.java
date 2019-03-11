package chapter3.example3_6;

class A { }
class B extends A { }
public class TestDownCasting {
	public static void main(String[] args) {
		A a = new A();
		if( a instanceof B) {
			B b = (B)a;
		}
	}
}
