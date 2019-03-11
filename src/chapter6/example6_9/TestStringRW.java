package chapter6.example6_9;

import java.io.*;

public class TestStringRW {
	public static void main(String[] args) throws Exception{
		StringWriter writer = new StringWriter();
		writer.write("ab");
		writer.close(); // 关闭流无效
		writer.write("cdefg", 1, 2);  //   1表示位置, 2表示长度,写入的子串是"de"
		System.out.println(writer.getBuffer()); // 得到StringBuffer
		String s = writer.toString(); // 得到String
		StringReader reader = new StringReader(s);
		reader.skip(2);	// 读指针指向字符d
		reader.skip(-1); // 读指针指向字符b
		System.out.println((char)reader.read());
		reader.close();
	}
}
