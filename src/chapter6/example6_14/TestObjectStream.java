package chapter6.example6_14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Point implements Serializable{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private transient int z; // transient修饰的字段不会参与序列化

	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public String toString() {
		return "(" + x + "," + y + "," + z + ")";
	}
}

public class TestObjectStream {

	public static void main(String[] args) throws Exception {
		String filename = "d:/Object.obj";
		FileOutputStream fos = new FileOutputStream(filename); //文件输出流
		ObjectOutputStream oos = new ObjectOutputStream(fos); // 对象输出流
		Point p = new Point(1, 2, 3);
		System.out.println("序列化前：" + p);
		oos.writeObject(p); // 将Point对象序列化成字节数组并写入到文件中
		oos.flush();
		oos.close();
		// 将点对象写入文件中
		FileInputStream fis = new FileInputStream(filename); // 文件输入流
		ObjectInputStream ois = new ObjectInputStream(fis); // 对象输入流
		p = (Point)ois.readObject(); // 从文件中读取数据并反序列化为Point对象 
		System.out.print("反序列化后：" + p);
		ois.close();
	}
	
}


