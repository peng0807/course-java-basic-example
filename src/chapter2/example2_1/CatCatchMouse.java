package chapter2.example2_1;

class Mouse { // 定义一个类：Mouse
	String name; // 定义Mouse的特征属性：name

	void stealFood() { // 定义Mouse的功能行为：stealFood
		System.out.println(name + "在偷吃");
	}

	void scream() { // 定义Mouse的功能行为：scream
		System.out.println(name + "在哭：吱吱吱");
	}
}

class Cat { // 定义一个类：Cat
	String name; // 定义Cat的特征属性：name

	void catchMouse(Mouse mouse) { // 定义Cat的功能行为：catchMouse
		System.out.println(name + "在抓" + mouse.name);
		mouse.scream(); // 激发mouse的scream行为
	}
}

public class CatCatchMouse {
	public static void main(String[] args) {
		Cat cat = new Cat(); // 创建一个对象，一只猫：cat
		cat.name = "Tom"; // 设置cat的name属性
		Mouse mouse = new Mouse(); // 创建一个对象，一只老鼠：mouse
		mouse.name = "Jerry"; // 设置mouse的name属性
		mouse.stealFood(); // 激发mouse的stealFood行为
		cat.catchMouse(mouse); // 激发cat的catchMouse行为
	}
}