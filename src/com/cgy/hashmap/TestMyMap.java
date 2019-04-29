package com.cgy.hashmap;

public class TestMyMap {

	public static void main(String[] args) {
		//testArrayListMap();
		
		//testLinkedListMap();
		
		testMyHashMap();
	}

	
	/**
	 * ����arrayList��д��map
	 */
	public static void testArrayListMap() {
		MyArrayListMap<String, Object> map =new MyArrayListMap();
		map.put("a", "aaaa");
		map.put("b", "bbbb");
		map.put("c", "cccc");
		map.put("d", "dddd");
		
		System.out.println(map.getValue("a"));
		
		map.put("a", "aaaa222");
		
		System.out.println(map.getValue("a"));
		
		map.remove("b");
		
		System.out.println(map.getValue("b"));
		
	}
	/**
	 * ����linkedlist��д��map
	 */
	public static void testLinkedListMap() {
		MyLinkedListMap<String, Object> map =new MyLinkedListMap();
		
		map.put("a", "aaaa");
		map.put("b", "bbbb");
		map.put("c", "cccc");
		map.put("d", "dddd");
		
		System.out.println(map.getValue("d")+"--"+map.size());
		
		map.put("a", "aaaa222");
		
		System.out.println(map.getValue("a")+"--"+map.size());
		
		map.remove("b");
		
		System.out.println(map.getValue("b")+"--"+map.size());
		
	}
	/**
	 * �������ݼӵ��������map
	 */
	public static void testMyHashMap() {
		MyHashMap<String, Object> map = new MyHashMap();
		
		map.put("1��", "1��");// 0
		map.put("2��", "2��");// 1
		map.put("3��", "3��");// 2
		map.put("4��", "4��");// 3
		map.put("6��", "6��");// 4
		map.put("7��", "7��");
		map.put("14��", "14��");

		map.put("22��", "22��");
		map.put("26��", "26��");
		map.put("27��", "27��");
		map.put("28��", "28��");
		map.put("66��", "66");
		map.put("30��", "30��");
		System.out.println("����ǰ����....");
		map.print();
		System.out.println("���ݺ�����....");
		map.put("31��", "31��");
		map.put("66��", "123466666");
		map.print();
		
		
		
	}
}
