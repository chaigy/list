package com.cgy.hashmap;

import java.util.LinkedList;


/**
 * 	基于链表的map
 * @author chaigy
 *
 */
public class MyLinkedListMap<Key,Value> {
	
	//数组中存放的是链表信息
	private LinkedList<Entry<Key,Value>>[] tables =new LinkedList[998];
	//记录实际的链表大小
	private int size;
	
	public void put(Key key,Value value) {
		
		Entry<Key, Value> entry = new Entry<>(key, value);
		int index = index(key);
		LinkedList<Entry<Key, Value>> list = tables[index];
		//如果对应数组的下标为空，说明这个是第一个元素
		if(list==null) {
			list = new LinkedList<>();
			list.add(entry);
			tables[index]=list;
			size++;
		}else {//数组下面已经有链表，则判断该key是否已经存在
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
	 *  判断数据应该放入的数组下标
	 * @param key
	 * @return
	 */
	private int index(Key key) {
		//空元素放在第一个位置
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
