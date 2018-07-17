package com.neusoft.test0717;

public class GGTest {
	public static void main(String[] args) {
		
		GG g1 = new GG();
		g1.a=10;
		
		/**
		 * 被static修饰的属性和方法 
		 * (对象名.)去调用   不推荐
		 * (类名.)去调用       推荐
		 */
		g1.b=10;
		g1.method1();
		System.out.println("------------------------");
		//问题1 a=0 b=0      a被
		GG g2 = new GG();
		g2.method1();
		
	}
}
