package chapter6.example6_8;

import java.io.*;

public class TestCharArray {

	public static void main(String[] args) throws Exception{
		CharArrayWriter writer = new CharArrayWriter(4); // 创建一个长度为4的字符数组作为缓冲区
		writer.close();	// 关闭流无效
		writer.write("abcd"); // 可以写入，创建的缓冲区大小会自动增长
		
		char[] buf = writer.toCharArray(); // 获取字符数组输出流内部的字符数组副本
		
		CharArrayReader reader = new CharArrayReader(buf); // 创建数据源buf的字符数组输入流
		reader.skip(2);	// 读指针移动2个单位, 指向字符c
		int ch = 0;
		int i = 0;	// 标记读取的字符次数
		while((ch = reader.read())!=-1) {
			System.out.print((char)ch);	// 读取一个字符
			i ++;
			if(i==2) {	// 当i=2时，做个标记
				reader.mark(4);	
			}
			if(i<=3) {	// 当i<=3时，重设读指针
				reader.reset();	
			}
		}
		System.out.println();
		reader.reset();	// 重设读指针
		System.out.println((char)reader.read());
		reader.close();
	}
}
