package com.neusoft.test0714;

import java.util.Scanner;

public class test2 {
	public static void main(String[] args) {
	/*	int a=1,b=2,c=0;
		int[] d = {0};
		
		add1(a,b,c);
		add1(a,b,d);
		
		System.out.println(c);
		System.out.println(d[0]);*/
		int i=0;
		i = add3(i);
		System.out.println("Êä³ö£º"+i);
	}
	
/*	public static void add1(int a,int b,int c){
//		int c=0;
		c=a+b;
	}
	
	public static void add1(int a,int b,int[] d){
		d[0]=a+b;
	}
	*/
	public static int add3(int i){
		System.out.println("ÇëÊäÈë£º");
		Scanner s = new Scanner(System.in);
		i = s.nextInt();
		return i;
		
	}
	
	
}
