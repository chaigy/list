package com.cgy.linkedList;

public class TestLinkedList {
	
	
	public static void main(String[] args) {
		
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.add("����");
		linkedList.add("����");
		linkedList.add("����");
		linkedList.add("����");
		for(int i=0;i<linkedList.size();i++) {
			System.out.println(linkedList.get(i));
		}
		System.out.println("---------------�ָ���---------------");
		
		linkedList.add(0,"bbb");
		
		for(int i=0;i<linkedList.size();i++) {
			System.out.println(linkedList.get(i));
		}
		System.out.println("---------------�ָ���---------------");
		linkedList.remove(4);
		for(int i=0;i<linkedList.size();i++) {
			System.out.println(linkedList.get(i));
		}
	}
}
