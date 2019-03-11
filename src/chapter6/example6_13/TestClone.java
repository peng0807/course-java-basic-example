package chapter6.example6_13;

class Point implements Cloneable {
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();	// 使用Object类默认的clone方法
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

class Line implements Cloneable {
	public Point p1;
	public Point p2;
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone(); // 使用Object类默认的clone方法
	}
//	@Override // 自定义clone方法，实现深层复制
//	protected Object clone() throws CloneNotSupportedException {
//		Line line = (Line)super.clone();
//		line.p1 = (Point)this.p1.clone();
//		line.p2 = (Point)this.p2.clone();
//		return line; 
//	}
	@Override
	public String toString() {
		return "Line [p1=" + p1 + ", p2=" + p2 + "]";
	}
}

public class TestClone {
	public static void main(String[] args) throws Exception{
		Point p1 = new Point(1,1);
		Point p2 = new Point(2,2);
		Line line = new Line(p1, p2);
		
		Point pointClone = (Point)p1.clone();  // 克隆p1对象
		Line lineClone = (Line)line.clone();		// 克隆line对象
		
		p1.x = -1;	
		System.out.println(pointClone);			// pointClone对象的x属性并未修改
		System.out.println(lineClone);			// lineClone对象的p1属性的 x属性修改了
	}
}