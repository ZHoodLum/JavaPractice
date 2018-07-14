package com.neusoft.test0714;

public class test1 {
	public static void main(String[] args) {
		aaa();
		aaa(6);
		aaa('自');
	}
	
	//参数个数相同 、参数类型不同 总下所述：叫做方法的重载
	/**
	 * 方法的重载就是在同一个类中允许同时存在一个以上同名的方法
	 * 方法的重载 只跟两个条件有关： 参数个数、参数类型
	 */
	

	
//	方法名相同     1，2参数个数不同
//	方法名相同     2，3参数个数相同，参数类型不同
	
	//1
	public static void aaa(){
		System.out.println("没有参数的aaa");
	}
	//2
	public static void aaa(int a){
		System.out.println("有参数的aaa");
	}
	//3
	public static void aaa(char a){
		System.out.println("有一个char参数的aaa");
	}
	
//	4  5是重载 因为顺序不同           因为参数类型不同
	
	//4
	public static void aaa(int b,char a){
		System.out.println("有一个char参数的aaa");
	}//5
	public static void aaa(char a,int b){
		System.out.println("有一个char参数的aaa");
	}
	
	/**
	 * 6 7不是重载
	 */
	
	//6
	/*public static void bbb(int b,char a){
		System.out.println("有一个char参数的bbb");
	}//7
	public static void bbb(int a,char b){
		System.out.println("有一个char参数的bbb");
	}*/
	
	
	/*
	 * 不是重载 跟参数返回值类型无关
	 */
	//8
	public static void ccc(int b,char a){
		System.out.println(a+b);
		System.out.println("有一个char参数的aaa");
	}//9
/*	public static int ccc(int b,char a){
		System.out.println("有一个char参数的aaa");
		return a+b;
	}*/
	
	public static void hit(int gongjili,int juli){
		
	}
	public static void hit(int gongji){
		
	}
	
}	
