package com.cgy.hashmap;

import java.util.LinkedList;


/**
 * 	���������map
 * @author chaigy
 *
 */
public class MyLinkedListMap<Key,Value> {
	
	//�����д�ŵ���������Ϣ
	private LinkedList<Entry<Key,Value>>[] tables =new LinkedList[998];
	//��¼ʵ�ʵ������С
	private int size;
	
	public void put(Key key,Value value) {
		
		Entry<Key, Value> entry = new Entry<>(key, value);
		int index = index(key);
		LinkedList<Entry<Key, Value>> list = tables[index];
		//�����Ӧ������±�Ϊ�գ�˵������ǵ�һ��Ԫ��
		if(list==null) {
			list = new LinkedList<>();
			list.add(entry);
			tables[index]=list;
			size++;
		}else {//���������Ѿ����������жϸ�key�Ƿ��Ѿ�����
			for(Entry<Key,Value> item:list) {
				if(key==null && item.key==null) {
					item.value=value;
				}else if(item.key.equals(key)) {
					item.value=value;
				}else {
					list.add(entry);
					size++;
				}
			}
		}
			
	}
	
	public Value getValue(Key key) {
		Entry<Key, Value> entry = get(key);
		if(entry!=null) {
			return entry.value;
		}
		return null;
	}
	
	public Entry<Key,Value> get(Key key) {
		int index = index(key);
		LinkedList<Entry<Key, Value>> linkedList = tables[index];
		if(linkedList!=null) {
			for(Entry<Key,Value> item:linkedList) {
				if(key==null && item.key==null) {
					return item;
				}else if(item.key.equals(key)) {
					return item;
				}else
					return null;
			}
		}
		return null;
	}
	
	public void remove(Key key) {
		int index = index(key);
		LinkedList<Entry<Key, Value>> linkedList = tables[index];
		Entry<Key, Value> entry = get(key);
		if(entry!=null) {
			linkedList.remove(entry);
			size--;
		}
	}
	/**
	 *  �ж�����Ӧ�÷���������±�
	 * @param key
	 * @return
	 */
	private int index(Key key) {
		//��Ԫ�ط��ڵ�һ��λ��
		if(key==null) return 0;
		
		int code = key.hashCode();
		return code%tables.length;
	}
	
	public int size() {
		return size;
	}
	
	
	private static class Entry<Key,Value>{
		private Key key;
		
		private Value value;
		
		Entry(Key key,Value value){
			this.key=key;
			this.value=value;
		}
		
	}
}
