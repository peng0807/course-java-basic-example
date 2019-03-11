package chapter4.example4_6;
import java.util.*;

public class TestScanner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		System.out.print("请输入一个整数:");
		int i = reader.nextInt();
		System.out.print("请输入一个浮点数:");
		double d = reader.nextDouble();
		System.out.print("请输入一个字符串:");
		String str = reader.next();
		
		System.out.println(i+":"+d+":"+str);
		reader.close();
	}

}
