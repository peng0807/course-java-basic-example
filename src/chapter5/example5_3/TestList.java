package chapter5.example5_3;

import java.util.*;

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
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) { // 如果obj指向的不是一个Person对象
			return false; // “Person”对象和“非Person”对象肯定是“不相等的”
		} else {
			Person p = (Person) obj; // 类型强制转换
			return p.name.equals(this.name) && p.age == this.age;
		}
	}
}

class ComparatorByName implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		return o1.name.compareTo(o2.name);
	}
}

public class TestList {
	public static void main(String[] args) {
		List<Person> list = new LinkedList<Person>();  // 创建容器list
		
		Person p1 = new Person(20, "c张三");
		Person p2 = new Person(22, "b李四");
		Person p3 = new Person(21, "a王五");
		list.add(p1); // 添加元素
		list.add(p2);
		list.add(p3);
		
		System.out.println("元素个数：" + list.size() );  // 获取元素个数
		
		System.out.println("排序前：");
		for(Person p : list) {	// 增强型for循环遍历list
			System.out.println(p);
		}
		
		Collections.sort(list);  // 使用Collections工具类对list元素进行排序
		
		System.out.println("排序后：");
		Iterator<Person> iterator = list.iterator(); // 获取list容器的Iterator类型的迭代器
		while(iterator.hasNext()) {  // 使用迭代器遍历list中的元素
			Person p = iterator.next();
			System.out.println(p);
		}
		
		Collections.sort(list, new ComparatorByName()); // 使用指定的比较器对list元素进行排序
		System.out.println("使用比较器进行排序后，逆向遍历的结果：");
		ListIterator<Person> listIterator = list.listIterator(list.size()); // 获取list容器中指定位置的ListIteraotr类型的迭代器
		while(listIterator.hasPrevious()) {  // 使用ListIteraotr类型的迭代器逆向遍历list中的元素
			Person p = listIterator.previous();
			System.out.println(p);
		}
		
		System.out.println("从集合中删除元素前，是否包含张三：" + list.contains(new Person(20,"c张三")));  // 根据元素的equals方法判断list中是否包含该元素
		System.out.println("元素张三的在list中的索引位置：" + list.indexOf(new Person(20,"c张三")));
		list.remove(new Person(20,"c张三"));  // 删除指定元素，
		System.out.println("元素个数：" + list.size() );
		System.out.println("从集合中删除元素后，是否包含张三：" + list.contains(p1));
		for(int i=0; i<list.size(); i++) {  // 使用列表特有的for循环方式，遍历列表list
			System.out.println(list.get(i));
		}
		
		list.clear();  // 清空集合中的元素
		System.out.println("清空集合中的元素后，集合是否为空：" + list.isEmpty());
	}
}
