package com.neusoft.test0718;

public class Test2 {
	
	public static void main(String[] args) {

		System.out.println("----Employee-----");
		/**
		 * 先调用父类构造器 然后在调用子类构造器
		 */
		Officer of = new Officer();
		of.show();
//		System.out.println(of.a);
		
		
	}
}
