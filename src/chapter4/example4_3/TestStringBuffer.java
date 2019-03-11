package chapter4.example4_3;

public class TestStringBuffer {
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = sb1.append("d");
		System.out.println(sb1==sb2);		// true
		System.out.println(sb1);		// "abcd"
		System.out.println(sb2);		// "abcd"
		
		System.out.println(sb1.delete(1, 2));
		System.out.println(sb1.insert(1, "b"));
	}
}
