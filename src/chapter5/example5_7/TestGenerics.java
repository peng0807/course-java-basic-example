package chapter5.example5_7;

import java.util.Comparator;

class MySorter<T extends Comparable<T>> {  // 定义的排序器类是一种泛型类， 限定的泛型T必须实现Comparable接口
	public void sort(T[] a) {  // 定义了一个泛型方法，限定了方法参数的类型必须是泛型T的数组类型 T[]
		T temp = null;
		for (int i = a.length - 1; i > 0; i--) {  // 使用冒泡算法对数组a中的元素进行排序
			for (int j = 0; j < i; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
	public void sort(T[] a, Comparator<T> comparator) {  // 可使用比较器comparator的排序方法
		T temp = null;
		for (int i = a.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (comparator.compare(a[j], a[j+1]) > 0) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}

class MyArrays {
	public static <T extends Comparable<T>> T getMin(T[] a) {
		T min = a[0];
		for(T t : a) {
			if(t.compareTo(min)<0) {
				min = t;
			}
		}
		return min;
	}
}

class ComparatorByName implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		return o1.name.compareTo(o2.name);
	}
}

class Person implements Comparable<Person> {
	public int age;
	public String name;
	
	public Person(){}
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() { // 重写继承自Object的toString方法
		return this.name + "的年龄是：" + this.age;
	}

	@Override
	public int compareTo(Person o) { // 实现compareTo方法
		return this.age - o.age; // 制定Person对象之间“按年龄比较”的规则
	}
}

public class TestGenerics {
	public static void main(String[] args) {
		Person[] p = new Person[3]; // 创建Person类型数组
		p[0] = new Person(20, "c张三"); // 创建数组元素所引用的对象
		p[1] = new Person(22, "b李四");
		p[2] = new Person(21, "a王五");
		
		MySorter<Person> sorter = new MySorter<Person>();
		System.out.println("按Person类制定的默认比较规则排序：");
		sorter.sort(p);
		for (Person e : p) {
			System.out.println(e);
		}
		
		System.out.println("按ComparatorByName制定的比较规则排序：");
		sorter.sort(p, new ComparatorByName());
		for (Person e : p) {
			System.out.println(e);
		}
		
		System.out.println("数组中最小的元素是： " + MyArrays.getMin(p));
		
	}
}
