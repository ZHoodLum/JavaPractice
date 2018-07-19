package com.neusoft.test0718;

public class Fu {
	
	//private 只能在类的内部使用
//	private int a;
//	
//	public void method1(){
//		
//	}
	/**
	 * 
	 * 被protected  与default相比 多了一个其他包中的子类  也可以访问
	 * 父类有的方法a 子类也有a;new 子类时，调用方法a ，会调用子类的方法a
	 * 
	 * 
	 */
//	protected int c=10;
	
	
	public void method1(){
		System.out.println("这里是父类method1");
	}
	
}
