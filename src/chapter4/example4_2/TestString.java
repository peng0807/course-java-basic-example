package chapter4.example4_2;

public class TestString {
	public static void main(String[] args) {
		System.out.println("abc".length());
		System.out.println("abc".equals("abc"));
		System.out.println("abc".equalsIgnoreCase("aBc"));
		System.out.println("abc".compareTo("abcd"));
		System.out.println("abcd".compareTo("aa"));
		System.out.println("abc".charAt(0));
		System.out.println("abcb".indexOf('b'));		
		System.out.println("abc".startsWith("ab"));
		System.out.println("abc".endsWith("bc"));
		System.out.println("abcb".substring(1, 3));
		System.out.println(" abc ".trim());
		
		String str1 = "abc";
		String str2 = "abc";
		String str3 = "ab" + "c";
		System.out.println(str1 == str2);	// 返回值是true
		System.out.println(str1 == str3);	// 返回值是true

		str1 = "abc";
		str2 = "abc";
		str3 = "ab" + "c";
		System.out.println(str1 == str2);	// 返回值是true
		System.out.println(str1 == str3);	// 返回值是true

		str1 = "ab";
		str2 = str1 + "c";
		str3 = new String(str2);
		System.out.println(str1 == str2);  // 返回值是false
		System.out.println(str2 == str3);  // 返回值是lse

		str1 = "abc";
		str2 = new String("abc");
		str3 = new String(str2);
		System.out.println(str1.equals(str2)); // 返回值是true
		System.out.println(str2.equals(str3)); // 返回值是true

	}
}