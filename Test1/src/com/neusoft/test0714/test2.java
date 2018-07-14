package com.neusoft.test0714;

public class test2 {
	public static void main(String[] args) {
		int a=1,b=2,c=0;
		int[] d = {0};
		
		add1(a,b,c);
		add1(a,b,d);
		
		System.out.println(c);
		System.out.println(d[0]);
	}
	
	public static void add1(int a,int b,int c){
//		int c=0;
		c=a+b;
	}
	
	public static void add1(int a,int b,int[] d){
		d[0]=a+b;
	}
	
	
	
	
}
