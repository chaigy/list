package com.cgy.arraylist;

import java.util.Arrays;

public class MyArrayList {
	
	//������ݵ����� �±��0��ʼ
	private Object[] object = {};
	//����ʵ�ʴ�С  ��1��ʼ
	private int size;
	//Ĭ�������С
	private static int default_capacity=5;
	
	//Ĭ�ϳ�ʼ��ʮ����С
	MyArrayList(){
		this(default_capacity);
	}
	/**
	 * 	��ʼ�����й̶���С��list
	 * @param capacity
	 */
	MyArrayList(int capacity){
		if(capacity<0) {
			throw new IllegalArgumentException("��ʼ����С����:"+capacity);
		}
		this.object = new Object[capacity];
	}
	
	
	public void add(Object obj) {
		//����������ʵ�ʳ����Ѿ������鳤��һ����ʱ�򣬽�������,��������һ������
		ensureExplicitCapacity(size+1);
		//������֮�󣬰Ѷ�Ӧ�����ݽ��и�ֵ
		object[size++] = obj;
	}
	
	public void add(int index,Object obj) {
		rangCheck(index);
		ensureExplicitCapacity(size+1);
		//ԭ���������ݣ������ƶ�һλ,�ƶ�����-�±�ĳ���
		System.arraycopy(object, index, object, index+1, size-index);
		//������ǰ��ֵ
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
		//�ƶ����һλ
		if(mvnLength>0)
		System.arraycopy(object, index+1, object, index, mvnLength);
		//�����һλ�ó�null  
		object[--size]=null;
		return oldValue;
	}
	
	//�жϴ��ݵ��±��Ƿ�Խ��
	public void rangCheck(int index) {
		if(index<0||index>size) {
			throw new ArrayIndexOutOfBoundsException("�����±�Խ����:index"+index+",size:"+size);
		}
	}
	
	public int size() {
		return size;
	}
	
	/**
	 *  ���ݷ���
	 *  minCapacity ��С���ݴ�С
	 */
	private void ensureExplicitCapacity(int minCapacity) {
		//���ʵ�ʴ�����ݴ�С�Ѿ������鳤��һ����
		if(size==object.length) {
			if(minCapacity-object.length>0) {
				System.out.println("���������ݷ���.....");
				grow(minCapacity);
			}
		}
	}
	
	private void grow(int minCapacity) {
		//��¼�ϵ������С
		int oldLength = object.length;
		//���ݱ�����0.5
		int newLength=oldLength+(oldLength >> 1);
		//������ݵĳ��Ȳ�������С���ݣ���ʹ����С����
		if(minCapacity>newLength) {
			newLength = minCapacity;
		}
		System.out.println("���ݵĳ��ȣ�oldLength:"+oldLength+"::newLength:"+newLength);
		//�������������ݵ�newLength����
		object = Arrays.copyOf(object, newLength);
		
	}
	
}
