package chapter6.example6_16;
import java.io.PrintStream;

public class TestIORedirect {

	public static void main(String[] args)  throws Exception{
		String str = "要输出的内容";
		PrintStream ps = new PrintStream("d:/out.txt");
		System.setOut(ps);  // 重定向标准输出流 
		System.out.println(str);
	}

}
