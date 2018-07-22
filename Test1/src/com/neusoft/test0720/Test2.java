package com.neusoft.test0720;

public class Test2 {
	public static void main(String[] args) {
		
		String a = "asdfghjkldf";
		//打印m-n个  后面的数 - 前面的数
		System.out.println(a.substring(1,2));
		
		System.out.println(a.indexOf("df"));
		//从(3)某个索引 像后面查找
		System.out.println(a.indexOf("df",3));
		
		//String.trim() 去除空格
		String b = "  ff  ff af  afa ";
		String b1 = "fa";
		String b2 = "  ff";
		
		System.out.println(b.trim());
		System.out.println(b1.trim());
		System.out.println(b2.trim());
		
		
		
		
		
		
		
	}
}
