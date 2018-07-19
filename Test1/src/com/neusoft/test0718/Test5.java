package com.neusoft.test0718;

public class Test5 {
	
	
	public static void main(String[] args) {
		Fu f1 = new Fu();
		
		Zi z1 = new Zi();//子类引用 指向父类 自己的类指向自己
//		z1.method1();
		
//		z1.method2();
		
		
		Fu fz = new Zi();//父类引用指向子类对象---->多态
		fz.method1();//父类给一个限制 ，只能调用我自己的有的方法
		if(fz instanceof Zi){
			System.out.println("fi是zi类");
		}
		if(fz instanceof Zi2){
			System.out.println("fi是zi2类");
		}
		//		fz.method2();
		
		/**
		 * 下溯转型 前提是之前经过了向上转型才能向下转型。
		 */
		Zi zfz = (Zi)fz;
		
	}
}
