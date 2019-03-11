package chapter5.example5_2;

import java.util.Arrays;
import java.util.Comparator;
class Person implements Comparable<Person> {
	public int age;
	public String name;
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {	// 重写继承自Object的toString方法
		return this.name + "的年龄是：" + this.age;
	}
	@Override
	public int compareTo(Person o) {	// 实现compareTo方法
		return this.age - o.age;	// 制定Person对象之间“按年龄比较”的规则
	}
}

class ComparatorByName implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		return o1.name.compareTo(o2.name);
	}
}

public class TestPersonArray {
	public static void main(String[] args) {
		Person[] p = new Person[3];	// 创建Person类型数组
		p[0] = new Person(20, "c张三");	// 创建数组元素所引用的对象
		p[1] = new Person(22, "b李四");
		p[2] = new Person(21, "a王五");
		System.out.println("排序前，使用普通的for循环遍历数组p");
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}
		Arrays.sort(p);
		System.out.println("排序后，使用增强型的for循环遍历数组p");
		for (Person e : p) {
			System.out.println(e);
		}
		System.out.print("排序后，在数组p中查找值等于21的元素，");
		int index = Arrays.binarySearch(p, new Person(21,"麻六"));
		System.out.println("下标值为：" + index);
		
		Arrays.sort(p, new ComparatorByName());
		System.out.println("按姓名排序后，使用增强型的for循环遍历数组p");
		for (Person e : p) {
			System.out.println(e);
		}
	}
}
