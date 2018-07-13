package com.neusoft.test0713;

import java.util.Random;
import java.util.Scanner;

public class Htest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("即将产生两位整数：");
//		Random r = new Random();
//		int a = r.nextInt();
//		System.out.println("产生A的值为："+a);
//		int b = r.nextInt();
//		System.out.println("产生B的值为："+b);
		
		int a = new Random().nextInt(10) + 1;
		System.out.println("产生A的值为："+a);
		int b = new Random().nextInt(10) + 1;
		System.out.println("产生B的值为："+b);
		
		int c = add(a,b);
		System.out.println("两位数相加等于："+c);
	}
	
	public static int add(int x,int y){
		return x+y;
	}

}
