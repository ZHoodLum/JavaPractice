package com.neusoft.test0720;

public class Test1 {
	
	public static void main(String[] args) {
		String a = "abcde";
		char[] b = {'a','b','c','d','e'};
		
		String c1 = null;
		char[] c2 = new char[5];
		/**
		 * char 转换为string 
		 */
		//
		System.out.println("String类的toCharArray()方法");
		c2 = a.toCharArray();
		for(char n:c2){
			System.out.println("输出N:"+n);
		}
		System.out.println();
		
		//
		System.out.println("方法1  String类的valueOf（char[]方法）");
		c1 = String.valueOf(b);
		System.out.println("使用valueOf:"+c1);
		System.out.println();
		
		//
		System.out.println("String的构造方法 new String (char[])");
		String c3 = new String(b);
		System.out.println(c3);
		
		//
		System.out.println("截取字符串位置");
		String c4 = new String(b,1,2);
		System.out.println(c4);
		System.out.println();
		
		
		//
		String c5 = 'a'+""+'b';
		System.out.println(c5);
		String c6 = "";
//		for(char)
		
		
		
		
		
	}
}
