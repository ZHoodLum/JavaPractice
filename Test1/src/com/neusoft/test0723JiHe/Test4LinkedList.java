package com.neusoft.test0723JiHe;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test4LinkedList {
	
	static LinkedList list1 = new LinkedList();
	static LinkedList list2 = new LinkedList();
	
	public static void main(String[] args) {
		//˫����   ����ṹ  ������    ��ɾ��
//		LinkedList list1 = new LinkedList();
//		LinkedList list2 = new LinkedList();
		
//		list1.add("������");
//		list1.add("������");
//		list1.add("������");
//		list1.add("�����");
//		list1.add("�����");
//		list1.add("��˼��");
		
		//��ջ   ʹ������ջ  �Ϳ���ʵ�ֶ��й���   �Ƚ����  ��ջ���ξ�ok
/*		list1.push("��˼��");
		list1.push("�����");
		list1.push("������");
		//��ջ
//		list1.pop();
		list2.push(list1.pop());
		list2.push(list1.pop());
		list2.push(list1.pop());
		
		
		Iterator i1 = list2.iterator();
		System.out.println("-----------");
		while(i1.hasNext()){//�ж� ���ƶ�ָ��		
			System.out.println(i1.next());
		}
	*/	
		Test4LinkedList t = new Test4LinkedList();
		t.put("aaa");
		t.put("bbb");
		t.put("ccc");
		
		
	}
	
	
	public void put(Object o){
		list1.push(o);
	}
	public Object get(){
		while(isEmpty(list1)){
			list2.push(list1.pop());
		}
		if(!isEmpty(list2)){
			return list2.pop();
		}else{
			return "�Բ���û����Ϊ�գ�";
		}
	}
	//�ж�list�Ƿ�Ϊ��
	public boolean isEmpty(List list){
		if(list.size()<=0){
			return true; //��Ϊ��
		}else{
			return false;//Ϊ��
		}
		
	}
	
}

