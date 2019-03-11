package chapter6.example6_3;

public class TestEncoding {
	public static void main(String[] args) throws Exception{
		String str = "ab中国";
		byte[] bytesGBK = str.getBytes(); // 使用ANSI编码，中文Windows系统下是GBK
		System.out.println(bytesGBK.length);  // 长度是6
		System.out.println(new String(bytesGBK, "UTF-8"));  // 使用UTF-8解码，出现乱码
		byte[] bytesUTF8 = str.getBytes("UTF-8");  // 指定GBK字符集进行编码
		System.out.println(bytesUTF8.length);  // 长度是8
		System.out.println(new String(bytesUTF8, "UTF-8"));  // 编码解码一致，没有乱码
	}
}
