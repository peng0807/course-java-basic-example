package chapter5.example5_4;

import java.util.*;

class HashMapKey {
	int i;
	public HashMapKey(int i) {
		this.i = i;
	}
	@Override
	public int hashCode() {
		return i*10000;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof HashMapKey)) { 
			return false;
		} else {
			HashMapKey key = (HashMapKey)obj ; // 类型强制转换
			return this.i == key.i;
		}
	}
	@Override
	public String toString() {
		return "MyHashMapKey [i=" + i + "]";
	}
}

public class TestHashMap {
	public static void main(String[] args) {	
		Map<HashMapKey, String> hashMap = new HashMap<HashMapKey, String>();
	
		HashMapKey key1 = new HashMapKey(2);  
		HashMapKey key2 = new HashMapKey(2);   // 注意：key1 和 key2 对象的 i 属性值相同
		
		System.out.println("key1==key2：" + (key1==key2));
		System.out.println("key1.equals(key2)：" + key1.equals(key2));
		System.out.println("key1.hashCode() == key2.hashCode()：" + (key1.hashCode() == key2.hashCode()));
		
		String value1 = "a";
		String value2 = "b";
		
		hashMap.put(key1, value1);  // 将 <key1, value1> 添加到Map集合
		hashMap.put(key2, value2);  // 将 <key2, value2> 添加到Map集合
		
		System.out.println("添加key1,key2后，map中的元素数量：" + hashMap.size());
		System.out.println("是否包含key1：" + hashMap.containsKey(key1));
		System.out.println("是否包含key2：" + hashMap.containsKey(key2));
		System.out.println("是否包含value1：" + hashMap.containsValue(value1));
		System.out.println("是否包含value2：" + hashMap.containsValue(value2));
		
		HashMapKey key3 = new HashMapKey(3);
		String value3 = "c";
		hashMap.put(key3, value3);
		
		System.out.println("添加key3后， 遍历key集的结果：");
		Set<HashMapKey> keys = hashMap.keySet();
		for(HashMapKey key : keys) {
			System.out.println(key);
		}
		System.out.println("添加key3后，遍历value集的结果：");
		Collection<String> values = hashMap.values();
		for(String value : values) {
			System.out.println(value);
		}
		System.out.println("添加key3后，遍历entry集的结果：");
		Set<Map.Entry<HashMapKey, String>> entries = hashMap.entrySet();
		for(Map.Entry<HashMapKey, String> entry : entries) {
			System.out.println("[" + entry.getKey().i + "," + entry.getValue() + "]");
		}
		System.out.println("删除的key2的value是："  + hashMap.remove(key2));
		hashMap.clear();
		System.out.println("调用clear方法后，是否清空：" + hashMap.isEmpty());
	}
}
