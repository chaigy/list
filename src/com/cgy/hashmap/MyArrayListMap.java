package com.cgy.hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * ����arraylist ������
 * @author chaigy
 *
 */
public class MyArrayListMap<Key,Value> {

	List<Entry<Key,Value>> tables = new ArrayList<>();

	/**
	 * 	��������
	 */
	public void put(Key key,Value value) {
		Entry entry = get(key);
		if(entry!=null) {//˵���Ѿ����ڣ����޸�
			entry.value=value;
			return;
		}
	//�����������	
	Entry<Key, Value> newEntry = new Entry<>(key, value);
	tables.add(newEntry);
		
	}
	
	/**
	 * ͨ��key��ȡ��Ӧ��valueֵ
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
	 * ͨ��key��ȡentry
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
	 *   ���� ʵ�壬��Ҫ�Ǵ洢key value ��Ϣ
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
