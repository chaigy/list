package com.cgy.linkedList;

/**
 *  手写linkedList
 *  	linkedList 是使用双向链表来实现的
 * @author chaigy
 *
 */
public class MyLinkedList {
	//链表实际长度
	private int size;
	//链表的头部元素 方便查询，从哪里开始
	private Node first;
	//链表的尾部元素，方便添加 从哪里插入
	private Node last;
	
	public void add(Object obj) {
		linkedLast(obj);
	}
	/**
	 * 	向尾部添加节点
	 * @param obj
	 */
	private void linkedLast(Object obj) {
		Node oldLast = last;
		//添加在后面的数据，没有下一个元素，上一个元素指向旧的lastNode
		Node newNode = new Node(oldLast, obj, null); 
		last = newNode;
		//如果旧的元素为空，则说明以前没有元素
		if(oldLast==null) 
			first= newNode;
		else
			oldLast.next= newNode;
		size++;
	}
	
	/**
	 * 向对应的下标添加节点
	 * @param index
	 * @param obj
	 */
	public void add(int index,Object obj) {
		rangCheck(index);
		//如果添加的末尾处
		if(index==size)
			linkedLast(obj);
		//其余的添加在非末尾位置
		else
			linkedOther(obj,node(index));
		
	}
	//添加到非末尾位置的数据
	private void linkedOther(Object obj, Node node) {
		//获取原节点的上一个节点信息
		Node oldPrev = node.prev;
		Node newNode =new Node(oldPrev, obj, node);
		node.prev = newNode;
		//如果本节点的上一个节点是null 说明是首节点
		if(oldPrev==null)
			first = newNode;
		//如果前一个节点不是null，说明是中间添加
		else
			oldPrev.next=newNode;
		
		size++;
		
	}
	//通过下标找到index对应的节点数据信息
	private Node node(int index) {
		//如果下标是在后半段
		if(index>=size>>1) {
			Node x = last;
			for(int i=size-1;i>index;i--) {
				x=x.prev;
			}
			return x;
		}else {//下标是在前半段
			Node x = first;
			for(int i=0;i<index;i++) {
				x=x.next;
			}
			return x;
		}
	}
	/**
	 * 返回对应下标的数据
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		
		return node(index).obj;
	}

	public Object remove(int index) {
		rangCheck(index);
		//需要被移除的节点
		Node oldNode = node(index);
		Node prev = oldNode.prev;
		Object data = oldNode.obj;
		Node next = oldNode.next;
		//如果移除的数据前一个节点是null，则说明移除的是first
		if(prev==null)
			first=next;
		else {
			prev.next=next;
			oldNode.prev=null;
		}
		if(next==null)
			last =prev;
		else {
			next.prev=prev;
			oldNode.next=null;
		}
		oldNode.obj=null;
		size--;
		return data;
	}
	
	private void rangCheck(int index) {
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException("下标越界：index："+index+",,size:"+size);
	}
	
	
	public int size() {
		return size;
	}
	
	
//初始化一个链表结构	
private static  class Node{
		//存放数据
		Object obj;
		//上一个节点
		Node prev;
		//下一个节点
		Node next;
		
		Node(Node prev,Object obj,Node next){
			this.prev=prev;
			this.obj=obj;
			this.next=next;
		}
	}
}