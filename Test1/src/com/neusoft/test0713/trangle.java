package com.neusoft.test0713;

import java.util.Scanner;

public class trangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ÅÅÐòÎÊÌâ
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
//		int c = s.nextInt();
//		int d = s.nextInt();
		
		if(a>b){
			int temp = a;
			a = b;
			b = temp;
		}
			System.out.println(a);
			System.out.println(b);
	}

}
