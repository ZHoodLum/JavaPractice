package com.neusoft.test;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int a = 0;
		System.out.println("ÇëÊäÈëaµÄÖµ£º");
		a = sc.nextInt();
		int b = a/100;
		int c = (a/100)%10;
		int d = (a%10)%10;
//		int b = a/100;
//		int c = (a/10)%10;
//		int d = a%10;
		System.out.println(b+c+d);
	}

}
