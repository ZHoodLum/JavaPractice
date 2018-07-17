package com.neusoft.test0717;

public class GG {
	public int a ;
	public static int b;
	
	public void method1(){
		System.out.println(a);
		System.out.println(b);
	}
	/**
	 * 普通的方法  在产生类的实例时，有了对象才能调用，
	 * 通过（对象名.）去调用
	 * 
	 * 普通的方法可以调用static方法，static修饰的比他产生的早
	 */
	public void method2(){
		method1();
	}
	/**
	 * 被static修饰的方法 我梦称之为类方法
	 * 
	 * 被static修饰的方法 可以调用其他的static  修饰的属性
	 * 被static修饰的方法  只能调用其他的static  修饰的方法或者属性
	 */
	public static void method3(){
		System.out.println(b);
		//System.out.println(a);不行
	}
	
	/**
	 * 被static修饰的方法可以调用其他 被static修饰的属性
	 * 因为他们都被加载到静态方法区  可以直接通过(类名.)去调用
	 * 
	 */
	public static void method4(){
		method3();
//		method1();
	}
	
}
