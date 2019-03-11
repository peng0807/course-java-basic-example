package chapter6.example6_6;

import java.io.*;

//public class TestInputStreamReader {
//
//	public static void main(String[] args) {
//		int c = 0;
//		char[] buf = new char[1024];
//		// FileReader fr = null;
//		// FileWriter fw = null;
//		InputStreamReader fr = null;
//		OutputStreamWriter fw = null;
//		try {
//			// fr = new FileReader("C:/FileTest.txt");
//			// fw = new FileWriter("C:/FileTest.txt");
//			fr = new InputStreamReader(new FileInputStream("C:/FileTest.txt"),
//					"gbk");
//			fw = new OutputStreamWriter(new FileOutputStream(
//					"C:/FileTestCopy-UTF8.txt"), "utf-8");
//			while ((c = fr.read(buf)) != -1) {
//				System.out.println(c);
//				fw.write(buf, 0 , c);
//			}
//			System.out.println("文件已复制");
//		} catch (IOException e) {
//			System.out.println("文件写入错误");
//		} finally {
//			if (null != fr) {
//				try {
//					fr.close();
//				} catch (IOException e) {
//					System.out.println("资源关闭错误");
//				}
//			}
//			if (null != fw) {
//				try {
//					fw.close();
//				} catch (IOException e) {
//					System.out.println("资源关闭错误");
//				}
//			}
//		}
//	}
//
//}

public class TestInputStreamReader{
	public static void main(String[] args) throws Exception{
		int count = 0;
		char[] buf = new char[1024];
		FileInputStream fis = new FileInputStream("C:/FileTest.txt");
		FileOutputStream fos = new FileOutputStream("C:/FileTest-UTF8.txt");
		InputStreamReader isr = new InputStreamReader(fis, "gbk");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		while ((count = isr.read(buf)) != -1) {
			osw.write(buf, 0 , count);
		}
		System.out.println("文件已复制");
		isr.close();
		osw.flush();
		osw.close();
	}
}
