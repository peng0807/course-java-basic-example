package chapter6.example6_5;
import java.io.*;

public class TestFileWriter {
	
	public static void main(String[] args) {
		FileWriter wirter = null;
		try {
			wirter = new FileWriter("C:/TestFile.txt");
			wirter.write("abcd中国");
			System.out.println("内容已写入文件");
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件");
		} catch (IOException e) {
			System.out.println("文件复制错误");
		} finally {
			if(null != wirter) {
				try {
					wirter.flush();
					wirter.close();
				} catch (IOException e) {
					System.out.println("资源关闭异常");
				}
			}
		}
	}
	
}

//public class TestFileWriter {
//	public static void main(String[] args) throws Exception{
//		FileWriter wirter = new FileWriter("C:/TestFile.txt");
//		wirter.write("abcd中国");
//		System.out.println("内容已写入文件");
//		wirter.flush();
//		wirter.close();
//	}
//}
