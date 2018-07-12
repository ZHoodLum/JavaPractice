package com.neusoft.test0711;

import java.util.Scanner;

public class test13 {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("ss");
//		int c=127+(-128);
//		System.out.println(c);
//		int a = 0 ;
//		a = a + 1;
//		System.out.println(a);
		Scanner s = new Scanner(System.in);
		int y = s.nextInt();
		int a = y/100;
		int b = (y/10)%10;
		int c = y%10;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(a+b+c);
	}
	
	
}
