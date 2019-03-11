package chapter3.example3_10;

interface Flyable {	// 定义一个接口，表示一个“能够飞的”的行为特征
	void fly();	// 定义一个抽象方法，表示这个行为特征中具有“飞”的功能
}

class Bird implements Flyable {
	public void fly() { // 实现接口Flyable中定义的抽象方法fly()，定义“鸟”是如何飞的
		System.out.println("小鸟在飞");
	}
}

class Airplane implements Flyable {
	public void fly() { // 实现接口Flyable中定义的抽象方法fly()，定义“飞机”是如何飞的
		System.out.println("飞机在飞");
	}
}

public class TestInterface {
	public static void main(String[] args) {
		Flyable flyable = new Bird();	// 等同于父类引用指向子类对象
		flyable.fly();	// 调用的是Bird类的fly()方法
		flyable = new Airplane();
		flyable.fly();	//	调用的是Airplane类的fly()方法
	}
}

abstract class Door {
	abstract void open();
	abstract void close();
}
interface Alarmable {
	void alram();
}
class SafetyDoor extends Door implements Alarmable {
	void open() {
		System.out.println("安全门打开");
	}
	void close() {
		System.out.println("安全门关闭");
	}
	public void alram() {
		System.out.println("安全门报警");
	}
}
