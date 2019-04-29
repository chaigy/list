package com.cgy.hashmap;

/**
 * 1.7基于array+单向链表的实现
 * @author chaigy
 *
 */
@SuppressWarnings("all")
public class MyHashMap<Key,Value> {
	//存放数据的链表
	Node<Key,Value>[] tables =null;
	//初始化数组大小
	int init_capacity=16;
	//负载因子
	float DEFAULT_LOAD_FACTOR =0.75f;
	//实际存储数据的大小
	private int size;
	
	
	public void put(Key key,Value value) {
		//如果为空，则初始化
		if(tables==null) {
			tables=new Node[init_capacity];
		}
		//如果实际存储数据大于 初始容量*负载因子 则扩容
		if(size>(tables.length*DEFAULT_LOAD_FACTOR)) {
			resize();
		}
		//把数据添加/修改到map中
		int index = index(key,tables.length);
		//取到对应下标的链表
		Node<Key, Value> node = tables[index];
		//如果改节点没有链表，则创建加入
		if(node==null) {
			node = new Node(key, value, null);
			tables[index]=node;
			size++;
		}else {
			//一直循环，直到链表为空
			Node<Key,Value> newNode = node;
			//如果查到key 则直接返回
			while(node!=null) {
				//如果本身有数据
				if(node.key.equals(key)||node.key==key) {
					node.value=value;
					return;
				}
				node =node.next;
			}
			
			node = new Node<Key,Value>(key,value,newNode);
			size++;
			tables[index]=node;
		}
	}
	
	public void print() {
		if(tables!=null) {
			System.out.println("map：size:"+size);
			for(int i=0;i<tables.length;i++) {
				Node<Key, Value> node = tables[i];
				if(node!=null) {
					while(node!=null) {
						System.out.print("[key:"+node.key+",value:"+node.value+"]");
						node =node.next;
					}
				}
				System.out.println();
			}
		}
	}
	
	
	/**
	 * 默认扩容两倍
	 */
	private void resize() {
		//默认扩容两倍
		Node<Key,Value>[]  newTable = new Node[tables.length << 1];
		//循环遍历旧tables有的数据，把他们进行新的hash放到新的tables中
		for(int i=0;i<tables.length;i++) {
			Node<Key, Value> oldList = tables[i];
			while(oldList!=null) {
				//直接把旧表的数据置成空值
				tables[i]=null;
				//获取旧的key，一遍计算hash
				Key oldKey = oldList.key;
				//保留旧的值，此值是循环下一次的值
				Node<Key, Value> oldNext = oldList.next;
				//计算出新的下标
				int index = index(oldKey,newTable.length);
				//这一步是关键，这样就把数据给链接起来了，如果不写的话，会出现错误
				oldList.next=newTable[index];
				//把新表的元素，赋值给改节点
				newTable[index]=oldList;
				oldList=oldNext;
			}
		}
		tables =newTable;
		newTable=null;
	}

	/**
	 * 根据key返回对应的下标
	 * @param key
	 * @param length
	 * @return
	 */
	private int index(Key key,int length) {
		if(key==null) {
			return 0;
		}
		int index = key.hashCode() % length;
		return index;
	}


	private static class Node<Key,Value>{
		
		private Key key;
		
		private Value value;
		
		private Node<Key,Value> next;
		
		Node(Key key,Value value,Node<Key,Value> next){
			this.key=key;
			this.value=value;
			this.next=next;
		}
		
		public Value setValue(Value value) {
			Value oldValue = this.value;
			this.value=value;
			return oldValue;
		}
		
		
	}
}
