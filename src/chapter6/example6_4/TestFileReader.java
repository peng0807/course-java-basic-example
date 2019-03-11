package chapter6.example6_4;

import java.io.*;

public class TestFileReader {

	public static void main(String[] args) {
		int b = 0;
		FileReader reader = null;
		try {
			reader = new FileReader("C:/FileTest.txt");
//			System.out.println("skip()：" + reader.skip(4));
			long num = 0;
			while ((b = reader.read()) != -1) {
				System.out.print((char)b);
				num++;
			}
			//使用字节数组做为缓冲，提高效率
			/*byte[] buffer = new byte[1024];
			int count = 0;
			while((count = in.read(buffer)) != -1) {
				System.out.println(new String(buffer));
				num += count;
			}*/
			System.out.println("\n共读取了 " + num + "个字符");
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件");
		} catch (IOException e) {
			System.out.println("文件读取错误");
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("资源关闭异常");
				}
			}
		}
	}
}

//public class TestFileReader {
//
//	public static void main(String[] args) throws Exception{
//		int b = 0;
//		FileReader reader = new FileReader("C:/FileTest.txt");
//		reader = new FileReader("C:/FileTest.txt");
//		long num = 0;
//		while ((b = reader.read()) != -1) {
//			System.out.print((char)b);
//			num++;
//		}
//		System.out.println("\n共读取了 " + num + "个字符");
//		reader.close();
//	}
//}