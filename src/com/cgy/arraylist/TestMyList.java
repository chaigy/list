package com.cgy.arraylist;

/**
 * ����myArrayList
 * @author chaigy
 *
 */
public class TestMyList {
	
	
	public static void main(String[] args) {
		
		MyArrayList list =new MyArrayList(1);
		list.add("����");
		list.add("����");
		list.add("����");
		list.add("����");
		list.add("����");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("---------------�ָ���---------------");
		list.add(4, "bb");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		list.remove(5);
		System.out.println("---------------�ָ���---------------");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
