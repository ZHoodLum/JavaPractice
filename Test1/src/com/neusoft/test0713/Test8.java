package com.neusoft.test0713;

public class Test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//method3
		int d=666;
		method3(d);		
	}
	public static void method3(int d){
		/*
		 * 栈   先进后出 
		 *  main方法 先进入栈   进行压栈执行语句，
		 *   method3后进入栈 执行method3中的程序
		 */
//		d=99;
		System.out.println(d);
		d=99;
	}
	
}
