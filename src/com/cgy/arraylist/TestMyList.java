package com.cgy.arraylist;

/**
 * 测试myArrayList
 * @author chaigy
 *
 */
public class TestMyList {
	
	
	public static void main(String[] args) {
		
		MyArrayList list =new MyArrayList(1);
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("赵六");
		list.add("陈七");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("---------------分割线---------------");
		list.add(4, "bb");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		list.remove(5);
		System.out.println("---------------分割线---------------");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
