package chapter6.example6_15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Point implements Serializable {	//	实现序列化接口
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

class Line implements Serializable {	// 实现序列化接口，所有属性必须能被序列化
	public Point p1;
	public Point p2;
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	@Override
	public String toString() {
		return "Line [p1=" + p1 + ", p2=" + p2 + "]";
	}
}

public class TestDeepClone {
	public static void main(String[] args) throws Exception{
		Point p1 = new Point(1,1);
		Point p2 = new Point(2,2);
		Line line = new Line(p1, p2);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(line);	// 将对象line序列化到baos流的字节数组中
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		Line lineClone = (Line)ois.readObject(); // 从 baos流的字节数组副本中，读取数据并反序列为对象
		
		p1.x = -1;
		System.out.println("line:" + line);
		System.out.println("lineClone:" + lineClone);
		System.out.println("line.p1 == lineClone.p1:" + (line.p1 == lineClone.p1));
	}
}