package com.neusoft.test0713;

public class Test7 {

	public static void main(String[] args) {
		//method1
		int b= 10;//如何可以在method1中使用呢？通过方法调用  定义的实参 传给方法中的形参
		method1(b);
		System.out.println("**********************************");
		//method2
		method2(9999);//方法中形参与实参个数、类型 一致才能调用当前方法
		System.out.println("**********************************");
		//method3
		int d=666;
		method3(d);
		
	}
	
	public static void method1(int x){
		
		//在方法中的变量 称之为局部变量 只限当前方法中使用 （专业名词：作用域当前方法！！）
		int a = 10;
		System.out.println(a);
		System.out.println("这劣势。。。");
	}
	
	public static void method2(int c){
		System.out.println(c);
	}
	
	public static void method3(int d){
		d=99;
		System.out.println(d);
		
	}
	
}
