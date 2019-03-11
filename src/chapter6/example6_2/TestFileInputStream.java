package chapter6.example6_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {

	public static void main(String[] args) {
		int b = 0;
		FileInputStream in = null;
		try {
			in = new FileInputStream("C:/FileTest.txt");
			System.out.println("available()：" + in.available());
			System.out.println("skip()：" + in.skip(4));
			long num = 0;
			while ((b = in.read()) != -1) {
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
			System.out.println("共读取了 " + num + "个字节");
			System.out.println("available()：" + in.available());
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件");
		} catch (IOException e) {
			System.out.println("文件读取错误");
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("资源关闭异常");
				}
			}
		}
	}
}