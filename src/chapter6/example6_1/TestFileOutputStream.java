package chapter6.example6_1;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {
	public static void main(String[] args) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("C:/TestFile.txt"); // 创建文件字节输出流
			byte[] data = "abcd中国".getBytes();  // 将字符串按系统默认字符集进行编码
			out.write(data); // 输出
			System.out.println("内容已写入文件");
		} catch (FileNotFoundException e) {
			System.out.println("或者该文件不存在，但无法创建它；或者该文件不存在，但无法创建它");
		} catch (IOException e) {
			System.out.println("文件复制错误");
		} finally {
			if(null != out) {
				try {
					out.flush();  // 刷新
					out.close();  // 关闭流对象
				} catch (IOException e) {
					System.out.println("资源关闭异常");
				}
			}
		}
	}
}
