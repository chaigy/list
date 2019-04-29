package com.cgy.linkedList;

public class TestLinkedList {
	
	
	public static void main(String[] args) {
		
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.add("张三");
		linkedList.add("李四");
		linkedList.add("王五");
		linkedList.add("赵六");
		for(int i=0;i<linkedList.size();i++) {
			System.out.println(linkedList.get(i));
		}
		System.out.println("---------------分割线---------------");
		
		linkedList.add(0,"bbb");
		
		for(int i=0;i<linkedList.size();i++) {
			System.out.println(linkedList.get(i));
		}
		System.out.println("---------------分割线---------------");
		linkedList.remove(4);
		for(int i=0;i<linkedList.size();i++) {
			System.out.println(linkedList.get(i));
		}
	}
}
