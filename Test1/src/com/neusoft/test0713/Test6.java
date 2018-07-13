package com.neusoft.test0713;

import java.util.Scanner;

public class Test6 {
/**
 * 
 * @param args
 */
	/*
	 * 形参与实参   也可以理解为 定义的变量  int i 与 给定实际数 i=10
	 * 形参与实参 个数一致、 类型一致
	 * return  返回值 谁调用  返回谁	
	 * 
	 * 方法分类：
	 * 		1、根据参数个数分类：    有参方法  ：8种数据类型 、引用数据类型  ；无参方法 ；
	 * 		2、根据返回值类型分类：   有返回值方法：返回值类型为基本数据类型、引用数据类型；
	 * 							无返回值方法：返回值类型使用void关键字
	 * 
	 * 方法可以重复调用
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int c = add(1,2);//方法的调用
//		System.out.println(c);
//		
//		int d = methoda();//方法的调用
//		System.out.println(d);
//		
//		double e = methodb();//方法的调用
//		System.out.println(e);
//		
//		String f = methodc("ssssss");//方法的调用
//		System.out.println(f);
//
//		method();
		add();
		
	}
	
	
//	方法
	
//	public static int add(int a ,int b){
//		
//		return a+b;//返回值 谁调用  返回谁		
//	}
//	
//	public static int methoda(){
//		return 10;	
//	}
//	
//	public static double methodb(){
//		return 99.0;	
//	}
//	public static String methodc(String a ){
//		return a;
//	}
//	public static void method(){
//		System.out.println("这里是method方法！");
//		
//	}
	public static void add(){
		double a=0,b=0,c=0;
		double r=1;
		Scanner sa = new Scanner(System.in);
		
		System.out.println("请输入一个数：");
		a=sa.nextDouble(); 
		
		System.out.println("请输入一个运算符：");
		String s = sa.next();
		
		System.out.println("请输入一个数：");
		b=sa.nextDouble();

		for(int i=0;i<=s.length()-1;i++) {
			if(s.equals("+")) {
				System.out.println("运算+得："+(c=a+b));
			}else if(s.equals("-")){
				System.out.println("运算-得："+(c=a-b));
			}else if(s.equals("*")){
				System.out.println("运算*得："+(c=a*b));
			}else if(s.equals("/")){
				if(b==0){
					System.out.println("除数不能为0！");
//					System.exit(0);
				}else{
				System.out.println("运算/得："+(c=a/b));
				}
			}
		}
	}
	
	
}
