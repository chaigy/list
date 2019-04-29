package com.cgy.hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于arraylist 的链表
 * @author chaigy
 *
 */
public class MyArrayListMap<Key,Value> {

	List<Entry<Key,Value>> tables = new ArrayList<>();

	/**
	 * 	插入数据
	 */
	public void put(Key key,Value value) {
		Entry entry = get(key);
		if(entry!=null) {//说明已经存在，则修改
			entry.value=value;
			return;
		}
	//不存在则添加	
	Entry<Key, Value> newEntry = new Entry<>(key, value);
	tables.add(newEntry);
		
	}
	
	/**
	 * 通过key获取对应的value值
	 * @param key
	 * @return
	 */
	public Value getValue(Key key) {
		Entry<Key,Value> entry = get(key);
		if(entry!=null) {
			return entry.value;
		}
		return null;
	}
	
	/**
	 * 通过key获取entry
	 * @param key
	 * @return
	 */
	public Entry<Key,Value> get(Key key) {
		for(Entry item:tables) {
			if(item.key.equals(key)) {
				return item;
			}
		}
		return null;
	}
	
	public void remove(Key key) {
		Entry<Key,Value> entry = get(key);
		if(entry!=null)
			tables.remove(entry);
	}
	public int size() {
		return tables.size();
	}
	
	/**
	 *   创建 实体，主要是存储key value 信息
	 * @author chaigy
	 *
	 */
	private static class Entry<Key,Value>{
		Key key;
		Value value;
		Entry(Key key,Value value){
			this.key=key;
			this.value=value;
		}
	}
}
