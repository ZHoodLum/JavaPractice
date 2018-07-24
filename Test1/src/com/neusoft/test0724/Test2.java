package com.neusoft.test0724;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Test2 {
	/**
	 * HashMap
	 * TreeMap
	 * 
	 * HashMap能放控制  而  terrMap不能
	 * 
	 * 
	 * 泛型只能写包装类数据类型 引用数据类型
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashMap h1 = new HashMap();
		h1.put(111, "11111");
		h1.put(222, "22222");
		h1.put(444, "33333");
		h1.put(333, "44444");
		
		System.out.println(h1.get(null));
		
		//遍历map集合两大思路
		/**
		 * 把k值看作一个set集合
		 * //1、把key值放入set集合当中 再利用set集合的iterator迭代器进行遍历
		 */
		
		Set<Integer> s1 = h1.keySet();
		Iterator i1 = s1.iterator();
		while(i1.hasNext()){
			System.out.println(i1.next());
		}
		System.out.println("*****");
		//思路2
		/**
		 * 泛型只能写包装类数据类型 引用数据类型
		 * 数据类型为Map.Entry<k, value>
		 * 把k  value值看作一个set集合
		 */
		Set<Map.Entry<Integer, String>> s2 = h1.entrySet();
		Iterator<Entry<Integer, String>> i2 = s2.iterator();
		while(i2.hasNext()){
			Map.Entry<Integer, String> me = i2.next();
			System.out.println(me.getValue()+":"+me.getValue());
		}
		System.out.println("*****");
		
		//思路3
		/**
		 * 只拿value值
		 * 
		 */
		Collection s3 = h1.values(); 
//		Set<Integer> s3 = (Set<Integer>) h1.values();
		Iterator<String> i3 = s3.iterator();
		while(i3.hasNext()){
			System.out.println(i3.next());
		}
		;
		
		System.out.println("---------------");
		TreeMap t1 = new TreeMap();
		t1.put(111, "11111");
		t1.put(222, "22222");
		t1.put(333, "33333");
		t1.put(444, "44444");
		
		System.out.println(t1.get(null));//空指针异常
	}
	
	
}
