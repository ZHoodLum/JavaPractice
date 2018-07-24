package com.neusoft.test0723JiHe;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test6HashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * TreeSet
		 * 
		 * HashSet   无序 不可重复   输出时数据无序  允许使用main值
		 * 如果equles值相等  那么Hashcode值一定相等
		 * 凡是Hash  都是无序的
		 * 
		 * 
		 */
		
		Set s = new HashSet();
		
		s.add("aaa");
		s.add("bbb");
		s.add("ccc");
		s.add("ddd");
		
		Iterator i = s.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
	}

}
