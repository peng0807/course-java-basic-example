package chapter4.example4_7;

import java.io.*;

//用户定义的异常，由Exception类派生
class UnSafePasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnSafePasswordException() {
		super("密码过于简单,安全密码的长度应大于6,且必须包含数字、大写字符和小写字母");
	}

	public UnSafePasswordException(String msg) {
		super(msg);
	}
}

public class ExceptionTest06 {
	// 抛出异常的方法
	static void checkPassword(String strPassword) throws UnSafePasswordException {
		if (strPassword.length() < 6)
			throw new UnSafePasswordException("密码长度太短");
		boolean bNumber = false;
		boolean bUpper = false;
		boolean bLower = false;
		for (int i = 0; i < strPassword.length(); i++) {
			if (bUpper && bLower && bNumber)
				break;
			if (strPassword.charAt(i) >= 'a' && strPassword.charAt(i) <= 'z')
				bLower = true;
			if (strPassword.charAt(i) >= 'A' && strPassword.charAt(i) <= 'Z')
				bUpper = true;
			if (strPassword.charAt(i) >= '0' && strPassword.charAt(i) <= '9')
				bNumber = true;
		}
		if (bUpper && bLower && bNumber) {
			System.out.println("密码是安全的");
			return;
		} else {
			throw new UnSafePasswordException();
		}
	}

	public static void main(String args[]) {
		try {
			System.out.println("请输入密码: ");
			BufferedReader stdin = new BufferedReader(new InputStreamReader(
					System.in));
			checkPassword(stdin.readLine());
		} catch (UnSafePasswordException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}