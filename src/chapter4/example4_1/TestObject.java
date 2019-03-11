package chapter4.example4_1;

class Person implements Cloneable{
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) { // 重写equals()方法
		if (!(obj instanceof Person)) { // 如果obj指向的不是一个Person对象
			return false; // “Person”对象和“非Person”对象肯定是“不相等的”
		} else {
			Person p = (Person) obj; // 类型强制转换
			return p.name.equals(this.name) && p.age == this.age;
		}
	}

	@Override
	public int hashCode() { // 重写hashCode()方法
		return this.name.hashCode() + 11 * age;
	}

	@Override
	public String toString() { // 重写toString()方法
		return this.name + "的年龄是" + this.age;
	}

}

public class TestObject {
	public static void main(String[] args) {
		Person p1 = new Person("张三", 20);
		Person p2 = new Person("张三", 20);
		
		System.out.println("p1.hashCode()=" + p1.hashCode());
		System.out.println("p2.hashCode()=" + p2.hashCode());
		System.out.println("p1.toString()=" + p1);
		System.out.println("p2.toString()=" + p2);
		System.out.println("p1.equals(p2)=" + (p1.equals(p2)));
		System.out.println("(p1==p2)=" + (p1 == p2));

		String s0 = "ab";
		String s1 = "b";
		String s2 = "a" + s1;
		System.out.println(s0);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println((s0 == s2.intern()));

		System.out.println("abc".compareTo("abcd"));
		System.out.println("abcd".compareTo("aa"));
		System.out.println("abc".startsWith("ab"));
		System.out.println("abc".endsWith("bc"));
		System.out.println("abcb".indexOf('b'));
		System.out.println("abcb".substring(1, 3));

		String s3 = p1 + "abc";
		System.out.println(s3);

		String str1 = new String("abc");
		String str2 = str1 + "d" + "e";
		String str3 = str2 + "f" + "g";
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = sb1.append("d");
		System.out.println(sb1 == sb2);
		System.out.println(sb1);
		System.out.println(sb2);

		int i = 10 + new Integer(5);
		System.out.println(i);

		String num = "12.5f";
		float myFloat = Float.parseFloat(num);
		boolean myBoolean = Boolean.parseBoolean("true");
		System.out.println(myFloat);
		System.out.println(myBoolean);
		System.out.println(String.valueOf(false));
		int[] a = new int[3];
		System.out.println(a);
		Person[] p = new Person[3];
		System.out.println(p);
		String[] s = new String[3];
		System.out.println(s);
	}

	void m() {
//		int i = 10 + new Integer(5);
		int j = Integer.valueOf(10);
		int[] a = new int[3];
		System.out.println(a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}

/*
 * class Person { String name; int age; Person(String name, int age) { this.name
 * = name; this.age = age; } }
 */