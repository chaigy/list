package com.cgy.arraylist;

import java.util.Arrays;

public class MyArrayList {
	
	//存放数据的数组 下标从0开始
	private Object[] object = {};
	//数组实际大小  从1开始
	private int size;
	//默认数组大小
	private static int default_capacity=5;
	
	//默认初始化十个大小
	MyArrayList(){
		this(default_capacity);
	}
	/**
	 * 	初始化具有固定大小的list
	 * @param capacity
	 */
	MyArrayList(int capacity){
		if(capacity<0) {
			throw new IllegalArgumentException("初始化大小错误:"+capacity);
		}
		this.object = new Object[capacity];
	}
	
	
	public void add(Object obj) {
		//当数组数据实际长度已经和数组长度一样的时候，进行扩容,最少扩容一个长度
		ensureExplicitCapacity(size+1);
		//扩容完之后，把对应的数据进行赋值
		object[size++] = obj;
	}
	
	public void add(int index,Object obj) {
		rangCheck(index);
		ensureExplicitCapacity(size+1);
		//原来数组数据，往后移动一位,移动长度-下标的长度
		System.arraycopy(object, index, object, index+1, size-index);
		//覆盖以前的值
		object[index]=obj;
		size++;
	}
	
	public Object get(int index) {
		rangCheck(index);
		return object[index];
	}
	
	public Object remove(int index) {
		rangCheck(index);
		Object oldValue = object[index];
		int mvnLength= size-index-1;
		//移动最后一位
		if(mvnLength>0)
		System.arraycopy(object, index+1, object, index, mvnLength);
		//把最后一位置成null  
		object[--size]=null;
		return oldValue;
	}
	
	//判断传递的下标是否越界
	public void rangCheck(int index) {
		if(index<0||index>size) {
			throw new ArrayIndexOutOfBoundsException("数组下标越界了:index"+index+",size:"+size);
		}
	}
	
	public int size() {
		return size;
	}
	
	/**
	 *  扩容方法
	 *  minCapacity 最小扩容大小
	 */
	private void ensureExplicitCapacity(int minCapacity) {
		//如果实际存放数据大小已经和数组长度一样大
		if(size==object.length) {
			if(minCapacity-object.length>0) {
				System.out.println("我走了扩容方法.....");
				grow(minCapacity);
			}
		}
	}
	
	private void grow(int minCapacity) {
		//记录老的数组大小
		int oldLength = object.length;
		//扩容倍数是0.5
		int newLength=oldLength+(oldLength >> 1);
		//如果扩容的长度不满足最小扩容，则使用最小扩容
		if(minCapacity>newLength) {
			newLength = minCapacity;
		}
		System.out.println("扩容的长度：oldLength:"+oldLength+"::newLength:"+newLength);
		//把现有数组扩容到newLength长度
		object = Arrays.copyOf(object, newLength);
		
	}
	
}
