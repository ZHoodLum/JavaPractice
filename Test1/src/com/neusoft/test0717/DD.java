package com.neusoft.test0717;

public class DD {
//	int a;
//	int b;
	private int c = 2;
	
	//add1实现a,b 相加的和
	public int add1(int a,int b){
		return add4(a,b);
	}
	
	//add2实现a,b 相加的和
	public int add2(int a,int b){
		int c =a + b;
		return c;
	}
	
	//add2实现a,b 相加的和
	public int add3(int a,int b){
		int d =a + b;
		return c*d;
	}
	
	//
	private int add4(int a,int b){
		return a*b;
	}
}
