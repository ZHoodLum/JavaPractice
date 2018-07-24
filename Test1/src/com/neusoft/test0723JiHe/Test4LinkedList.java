package com.neusoft.test0723JiHe;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test4LinkedList {
	
	static LinkedList list1 = new LinkedList();
	static LinkedList list2 = new LinkedList();
	
	public static void main(String[] args) {
		//双链表   链表结构  查找慢    增删快
//		LinkedList list1 = new LinkedList();
//		LinkedList list2 = new LinkedList();
		
//		list1.add("古天乐");
//		list1.add("渣渣会");
//		list1.add("爱迪生");
//		list1.add("贝多芬");
//		list1.add("孙红雷");
//		list1.add("王思聪");
		
		//入栈   使用两个栈  就可以实现队列功能   先进后出  进栈两次就ok
/*		list1.push("王思聪");
		list1.push("孙红雷");
		list1.push("爱迪生");
		//出栈
//		list1.pop();
		list2.push(list1.pop());
		list2.push(list1.pop());
		list2.push(list1.pop());
		
		
		Iterator i1 = list2.iterator();
		System.out.println("-----------");
		while(i1.hasNext()){//判断 不移动指针		
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
			return "对不起没返回为空！";
		}
	}
	//判断list是否为空
	public boolean isEmpty(List list){
		if(list.size()<=0){
			return true; //不为空
		}else{
			return false;//为空
		}
		
	}
	
}

