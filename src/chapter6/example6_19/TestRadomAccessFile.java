package chapter6.example6_19;

import java.io.RandomAccessFile;
import java.nio.charset.Charset;

public class TestRadomAccessFile {
	public static void main(String[] args) throws Exception{
		RandomAccessFile raf = new RandomAccessFile("D:/test.txt", "rw");
		System.out.println(raf.length());	//  输出文件的长度
		raf.writeInt(1); // 写入整型数据，4个字节
		raf.writeUTF("abcd汉字"); // 写入字符串，字节数=2+4+6
		System.out.println(raf.getFilePointer()); // 输出读写指针的位置
		raf.seek(0); // 将读写指针移动文件开始处
		System.out.println(raf.readInt()); // 读取4个字节并转为整型
		System.out.println(raf.readUTF()); // 读取字符串
		raf.seek(0); // 将读写指针移动文件开始处
		raf.skipBytes(4);	 // 读写指针向后移动4个字节，即跳过整型数据
		System.out.println(raf.readUTF()); // 读取字符串
		raf.seek(99);	// 将读写指针移动到99位置
		raf.write(0x61); // 写入字母a
		System.out.println(raf.length()); // 输出文件的长度
		raf.close();
	}
}
