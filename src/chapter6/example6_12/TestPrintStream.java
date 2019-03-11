package chapter6.example6_12;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class TestPrintStream {
	static final byte[] arr={0x61, 0x62, 0x63, 0x64, 0x65 }; // abced
	static final int i = 10;
	static final boolean b = true;
	static final String str = "字符串abc";

	public static void main(String[] args) throws Exception{
		FileOutputStream fos1 = new FileOutputStream("d:/out.txt");
		PrintStream ps1 = new PrintStream(fos1);
		ps1.write(arr);
		ps1.print(i);
		ps1.print(b);
		ps1.print(str);
		ps1.close();
		
		FileOutputStream fos2 = new FileOutputStream("d:/out-UTF8.txt");
		PrintStream ps2 = new PrintStream(fos2, true, "UTF-8"); // 指定字符集为UTF8
		ps2.write(arr);
		ps2.print(i);
		ps2.print(b);
		ps2.print(str);
		ps2.close();
		
		FileOutputStream fos3 = new FileOutputStream("d:/out-format.txt");
		PrintStream ps3 = new PrintStream(fos3);
		ps3.printf("My name is %2$s %1$s%n", "san", "zhang"); // zhang san
		ps3.printf("浮点数只保留2位小数: %.2f%n", 10.1010101); // 10.10
		ps3.printf("整数不够4位，前面补足零: %04d%n", 100); // 0100
		ps3.printf("当前时间是:%1$tF %1$tT" , new Date()); // yyyy-MM-dd HH:mm:ss
		ps3.close();
	}

}
