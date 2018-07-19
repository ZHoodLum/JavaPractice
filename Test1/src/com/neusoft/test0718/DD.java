package com.neusoft.test0718;

//public class DD extends CC {
//	被final修饰的类 不能够继承
//}
/**
 * 
 * abstract 在类名前的 修饰符看到abstract 叫做抽象类
 * 抽象类的产生  是让我们来继承的
 * 抽象类 是创建其他普通类的模板
 *
 */
	public 	abstract class DD {
	
	public int a =10;
	
	
	public void method1(){
		System.out.println("dd   mesthod1");
	}
	
	/**
	 * 抽象方法
	 */
	public abstract void method2();
	
}