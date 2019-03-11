package chapter3.example3_9;

abstract class Shape {	// 抽象类
	double area; // 属性：面积
	abstract void caculateArea();	//抽象方法，只有方法签名，没有方法体
	void printArea() {
		System.out.println("面积是：" + this.area);
	}
}

class Circle extends Shape {
	double radius; // 属性：半径
	public Circle(double radius) {
		this.radius = radius;
		caculateArea();
	}
	void caculateArea() { // 功能：计算面积
		area = Math.PI * radius * radius;
	}
}

class Rectangle extends Shape {
	double width; // 属性：宽
	double height; // 属性：高
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
		caculateArea();
	}
	void caculateArea() { // 功能：计算面积
		area = width * height;
	}
}

public class TestAbstract {
	public static void main(String[] args) {
		Shape s = new Circle(1);
		s.printArea();
		s = new Rectangle(2,3);
		s.printArea();
//		Shape s = new Shape();
	}
}

abstract class A {
	abstract void m1();
	abstract void m2();
}
class B extends A {
	void m1() {}
	void m2() {}
}

abstract class T {
	abstract  void m();
}









