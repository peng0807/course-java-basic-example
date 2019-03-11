package chapter6.example6_7;

import java.io.*;
public class TestByteArrayStream {
	public static void main(String[] args) throws Exception{
		byte b = 10;
		String str = "hello";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		out.write(b);  // 写入一个字节
		out.write(str.getBytes());  // 写入一个字节数组
		
		byte[] buf = out.toByteArray();  // 得到字节数组输出流的缓冲字节数组
		
		ByteArrayInputStream in = new ByteArrayInputStream(buf);
		System.out.println(in.read());  // 读取一个字节
		byte[] strBuf = new byte[32];
		int count = in.read(strBuf);  // 读取<=strBuf.length的字节数，返回读取的字节数
		System.out.println(new String(strBuf, 0 , count)); 
		
	}
}
