package com.neusoft.test0717;

public class DDTest {
	public static void main(String[] args) {
		//请实现两个数的和并输出
		int a=5;
		int b=10;
		DD dd = new DD();
		
		
		System.out.println(dd.add1(a, b));
		
		System.out.println(dd.add2(a, b));
		//实现两个数和的2倍
		System.out.println(dd.add3(a, b));
		/**
		 * 若c定义为  int c=2;
		 * 会造成数据外漏   因为其他类可以随意调用
		 * dd.c=3;
		 * System.out.println(dd.add3(a, b));
		 */
		//设置private  只能在当前类  内部访问
		System.out.println(dd.add3(a, b));
		
		
		/**
		 * 
		 */
		
		
		
		
		
	}
}
