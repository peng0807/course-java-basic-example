package chapter5.example5_6;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

public class TestSet {

	public static void main(String[] args) {
		Set<Person> hashSet = new HashSet<Person>();
		Person p1 = new Person(20, "c张三");
		Person p2 = new Person(22, "b李四");
		Person p3 = new Person(21, "a王五");
		hashSet.add(p1);
		hashSet.add(p2);
		hashSet.add(p3);
		System.out.println("添加p4前，元素个数：" + hashSet.size() );  // 获取元素个数
		Person p4 = new Person(20, "c张三");
		hashSet.add(p4);
		System.out.println("添加p4后，元素个数：" + hashSet.size());
		System.out.println("hashSet遍历的结果：");
		for(Person p : hashSet) {
			System.out.println(p);
		}
		SortedSet<Person> treeSet = new TreeSet<Person>(hashSet);
		Iterator<Person> iterator = treeSet.iterator();
		System.out.println("treeSet遍历的结果：");
		while(iterator.hasNext()) {
			Person p = iterator.next();
			System.out.println(p);
		}
	}

}
