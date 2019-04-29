package com.cgy.linkedList;

/**
 *  ��дlinkedList
 *  	linkedList ��ʹ��˫��������ʵ�ֵ�
 * @author chaigy
 *
 */
public class MyLinkedList {
	//����ʵ�ʳ���
	private int size;
	//�����ͷ��Ԫ�� �����ѯ�������￪ʼ
	private Node first;
	//�����β��Ԫ�أ�������� ���������
	private Node last;
	
	public void add(Object obj) {
		linkedLast(obj);
	}
	/**
	 * 	��β����ӽڵ�
	 * @param obj
	 */
	private void linkedLast(Object obj) {
		Node oldLast = last;
		//����ں�������ݣ�û����һ��Ԫ�أ���һ��Ԫ��ָ��ɵ�lastNode
		Node newNode = new Node(oldLast, obj, null); 
		last = newNode;
		//����ɵ�Ԫ��Ϊ�գ���˵����ǰû��Ԫ��
		if(oldLast==null) 
			first= newNode;
		else
			oldLast.next= newNode;
		size++;
	}
	
	/**
	 * ���Ӧ���±���ӽڵ�
	 * @param index
	 * @param obj
	 */
	public void add(int index,Object obj) {
		rangCheck(index);
		//�����ӵ�ĩβ��
		if(index==size)
			linkedLast(obj);
		//���������ڷ�ĩβλ��
		else
			linkedOther(obj,node(index));
		
	}
	//��ӵ���ĩβλ�õ�����
	private void linkedOther(Object obj, Node node) {
		//��ȡԭ�ڵ����һ���ڵ���Ϣ
		Node oldPrev = node.prev;
		Node newNode =new Node(oldPrev, obj, node);
		node.prev = newNode;
		//������ڵ����һ���ڵ���null ˵�����׽ڵ�
		if(oldPrev==null)
			first = newNode;
		//���ǰһ���ڵ㲻��null��˵�����м����
		else
			oldPrev.next=newNode;
		
		size++;
		
	}
	//ͨ���±��ҵ�index��Ӧ�Ľڵ�������Ϣ
	private Node node(int index) {
		//����±����ں���
		if(index>=size>>1) {
			Node x = last;
			for(int i=size-1;i>index;i--) {
				x=x.prev;
			}
			return x;
		}else {//�±�����ǰ���
			Node x = first;
			for(int i=0;i<index;i++) {
				x=x.next;
			}
			return x;
		}
	}
	/**
	 * ���ض�Ӧ�±������
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		
		return node(index).obj;
	}

	public Object remove(int index) {
		rangCheck(index);
		//��Ҫ���Ƴ��Ľڵ�
		Node oldNode = node(index);
		Node prev = oldNode.prev;
		Object data = oldNode.obj;
		Node next = oldNode.next;
		//����Ƴ�������ǰһ���ڵ���null����˵���Ƴ�����first
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
			throw new IndexOutOfBoundsException("�±�Խ�磺index��"+index+",,size:"+size);
	}
	
	
	public int size() {
		return size;
	}
	
	
//��ʼ��һ������ṹ	
private static  class Node{
		//�������
		Object obj;
		//��һ���ڵ�
		Node prev;
		//��һ���ڵ�
		Node next;
		
		Node(Node prev,Object obj,Node next){
			this.prev=prev;
			this.obj=obj;
			this.next=next;
		}
	}
}