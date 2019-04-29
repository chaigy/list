package com.cgy.hashmap;

/**
 * 1.7����array+���������ʵ��
 * @author chaigy
 *
 */
@SuppressWarnings("all")
public class MyHashMap<Key,Value> {
	//������ݵ�����
	Node<Key,Value>[] tables =null;
	//��ʼ�������С
	int init_capacity=16;
	//��������
	float DEFAULT_LOAD_FACTOR =0.75f;
	//ʵ�ʴ洢���ݵĴ�С
	private int size;
	
	
	public void put(Key key,Value value) {
		//���Ϊ�գ����ʼ��
		if(tables==null) {
			tables=new Node[init_capacity];
		}
		//���ʵ�ʴ洢���ݴ��� ��ʼ����*�������� ������
		if(size>(tables.length*DEFAULT_LOAD_FACTOR)) {
			resize();
		}
		//���������/�޸ĵ�map��
		int index = index(key,tables.length);
		//ȡ����Ӧ�±������
		Node<Key, Value> node = tables[index];
		//����Ľڵ�û�������򴴽�����
		if(node==null) {
			node = new Node(key, value, null);
			tables[index]=node;
			size++;
		}else {
			//һֱѭ����ֱ������Ϊ��
			Node<Key,Value> newNode = node;
			//����鵽key ��ֱ�ӷ���
			while(node!=null) {
				//�������������
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
			System.out.println("map��size:"+size);
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
	 * Ĭ����������
	 */
	private void resize() {
		//Ĭ����������
		Node<Key,Value>[]  newTable = new Node[tables.length << 1];
		//ѭ��������tables�е����ݣ������ǽ����µ�hash�ŵ��µ�tables��
		for(int i=0;i<tables.length;i++) {
			Node<Key, Value> oldList = tables[i];
			while(oldList!=null) {
				//ֱ�ӰѾɱ�������óɿ�ֵ
				tables[i]=null;
				//��ȡ�ɵ�key��һ�����hash
				Key oldKey = oldList.key;
				//�����ɵ�ֵ����ֵ��ѭ����һ�ε�ֵ
				Node<Key, Value> oldNext = oldList.next;
				//������µ��±�
				int index = index(oldKey,newTable.length);
				//��һ���ǹؼ��������Ͱ����ݸ����������ˣ������д�Ļ�������ִ���
				oldList.next=newTable[index];
				//���±��Ԫ�أ���ֵ���Ľڵ�
				newTable[index]=oldList;
				oldList=oldNext;
			}
		}
		tables =newTable;
		newTable=null;
	}

	/**
	 * ����key���ض�Ӧ���±�
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
