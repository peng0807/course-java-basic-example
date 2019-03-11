package chapter4.example4_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest04 {

	static int[] a = { 1, 2, 3 };

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			System.out.println(a[i]); // 数组下标越界异常是运行时异常、不捕获也可以通过编译
		}

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String line = in.readLine(); //IO异常是非运行时异常，必须要捕获，否则无法通过编译
			System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
