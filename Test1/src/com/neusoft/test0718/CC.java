package com.neusoft.test0718;

public final class CC {
	
	public int a=10;
	/*
	 * 最终，被final修改的变量，不能修改变量值
	 * 被final修饰的类 不能够继承
	 * 被final修饰的方法不能够被重写、覆盖。
	 */
	public final int b=10;
	
	public void method1(){
		System.out.println("cc   mesthod1");
	}
	
	public final void method2(){
		System.out.println("cc   mesthod2");
	}
	/*
	 * 
	 * 抽象类和接口 里面只能定义抽象方法，只能定义public 常量
	 * 而抽象类可以定义普通方法也可以定义抽象方法 
	 * 
	 * 抽象类可以是实现接口 抽象类可以继承抽象类 但是只能单继承。
	 * 而接口可以继承抽象类，可以多继承
	 * 都不能被实例化
	 */
	
	
}
