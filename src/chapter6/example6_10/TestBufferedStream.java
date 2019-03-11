package chapter6.example6_10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

public class TestBufferedStream {
	public static void main(String[] args) throws Exception{
		long beginTime = new Date().getTime();
		FileInputStream fis = new FileInputStream("D:/test.zip");
		FileOutputStream fos = new FileOutputStream("D:/testCopy1.zip");
		int c = 0;
		while((c = fis.read()) != -1) {  // 每次读写1个字节
			fos.write(c);
		}
		fis.close();
		fos.close();
		long endTime = new Date().getTime();
		System.out.println("文件已复制，未使用缓冲流，总共花费时间：" + (endTime-beginTime) + "毫秒");
		
		beginTime = new Date().getTime();
		fis = new FileInputStream("D:/test.zip");
		fos = new FileOutputStream("D:/testCopy2.zip");
		BufferedInputStream bis = new BufferedInputStream(fis);  // 创建缓冲流
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		c = 0;
		while((c = bis.read()) != -1) {  // 使用缓冲流每次读写1个字节，减少磁盘IO
			bos.write(c);
		}
		bis.close();
		bos.flush();
		bos.close();
		endTime = new Date().getTime();
		System.out.println("文件已复制，使用缓冲流，总共花费时间：" + (endTime-beginTime) + "毫秒");
		
		beginTime = new Date().getTime();
		fis = new FileInputStream("D:/test.zip");
		fos = new FileOutputStream("D:/testCopy3.zip");
		int len = 0;
		byte[] buffer = new byte[4096];  //  自定义缓冲区
		while((len=fis.read(buffer)) != -1) {   //  每次读写多个字节
			fos.write(buffer, 0, len);
		}
		fis.close();
		fos.close();
		endTime = new Date().getTime();
		System.out.println("文件已复制，使用自定义缓冲区，总共花费时间：" + (endTime-beginTime) + "毫秒");
	}
}

