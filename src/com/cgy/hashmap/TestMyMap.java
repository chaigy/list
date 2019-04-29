package com.cgy.hashmap;

public class TestMyMap {

	public static void main(String[] args) {
		//testArrayListMap();
		
		//testLinkedListMap();
		
		testMyHashMap();
	}

	
	/**
	 * ²âÊÔarrayList±àÐ´µÄmap
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
	 * ²âÊÔlinkedlist±àÐ´µÄmap
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
	 * ²âÊÔÊý¾Ý¼Óµ¥ÏîÁ´±íµÄmap
	 */
	public static void testMyHashMap() {
		MyHashMap<String, Object> map = new MyHashMap();
		
		map.put("1ºÅ", "1ºÅ");// 0
		map.put("2ºÅ", "2ºÅ");// 1
		map.put("3ºÅ", "3ºÅ");// 2
		map.put("4ºÅ", "4ºÅ");// 3
		map.put("6ºÅ", "6ºÅ");// 4
		map.put("7ºÅ", "7ºÅ");
		map.put("14ºÅ", "14ºÅ");

		map.put("22ºÅ", "22ºÅ");
		map.put("26ºÅ", "26ºÅ");
		map.put("27ºÅ", "27ºÅ");
		map.put("28ºÅ", "28ºÅ");
		map.put("66ºÅ", "66");
		map.put("30ºÅ", "30ºÅ");
		System.out.println("À©ÈÝÇ°Êý¾Ý....");
		map.print();
		System.out.println("À©ÈÝºóÊý¾Ý....");
		map.put("31ºÅ", "31ºÅ");
		map.put("66ºÅ", "123466666");
		map.print();
		
		
		
	}
}
