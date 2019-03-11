package chapter5.example5_5;

import java.util.*;

class TreeMapKey implements Comparable<TreeMapKey>{
	int i;
	public TreeMapKey(int i) {
		this.i = i;
	}
	@Override
	public int compareTo(TreeMapKey o) {
//		return 1;
		return this.i - o.i;
	}
	@Override
	public String toString() {
		return "TreeMapKey [i=" + i + "]";
	}
}

public class TestTreeMap {
	public static void main(String[] args) {	
		SortedMap<TreeMapKey, String> treeMap = new TreeMap<TreeMapKey, String>();
	
		TreeMapKey key1 = new TreeMapKey(2);
		TreeMapKey key2 = new TreeMapKey(2); 
		
		System.out.println("key1==key2：" + (key1==key2));
		System.out.println("key1.equals(key2)：" + key1.equals(key2));
		System.out.println("key1.hashCode() == key2.hashCode()：" + (key1.hashCode() == key2.hashCode()));
		System.out.println("key1.compareTo(key2)：" + key1.compareTo(key2));
		
		String value1 = "a";
		String value2 = "b";
		
		treeMap.put(key1, value1);
		treeMap.put(key2, value2);
		
		System.out.println("map中的元素数量：" + treeMap.size());
		System.out.println("是否包含key1：" + treeMap.containsKey(key1));
		System.out.println("是否包含key2：" + treeMap.containsKey(key2));
		System.out.println("是否包含value1：" + treeMap.containsValue(value1));
		System.out.println("是否包含value2：" + treeMap.containsValue(value2));
		
		TreeMapKey key3 = new TreeMapKey(3);
		String value3 = "c";
		treeMap.put(key3, value3);
		
		System.out.println("遍历key集");
		Set<TreeMapKey> keys = treeMap.keySet();
		for(TreeMapKey key : keys) {
			System.out.println(key);
		}
		System.out.println("遍历value集");
		Collection<String> values = treeMap.values();
		for(String value : values) {
			System.out.println(value);
		}
		System.out.println("遍历entry集");
		Set<Map.Entry<TreeMapKey, String>> entries = treeMap.entrySet();
		for(Map.Entry<TreeMapKey, String> entry : entries) {
			System.out.println("[" + entry.getKey().i + "," + entry.getValue() + "]");
		}
		
		System.out.println("firstKey是：" + treeMap.firstKey());
		System.out.println("lastkey是：" + treeMap.lastKey());
		
		SortedMap<TreeMapKey, String> headMap = treeMap.headMap(key3);
		System.out.println("headMap(key3)：" + headMap);
		SortedMap<TreeMapKey, String> tailMap = treeMap.tailMap(key3);
		System.out.println("tailMap(key3)：" + tailMap);
		
		System.out.println("删除的key2的value是："  + treeMap.remove(key2));
		treeMap.clear();
		System.out.println("调用clear方法后，是否清空：" + treeMap.isEmpty());
	}
}
