package com.neusoft.test0712;

import java.util.Scanner;

public class Htest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入一个正整数：");
		Scanner sr = new Scanner(System.in);
		int n = sr.nextInt();
		int s = 0;
		for(int a = 1;a<=n;a+=2){
			s = s+a;	
		}
		System.out.println("截止到"+n+"所有奇数和为："+s);
		
//		int a = 1;
//		int s = 0;
//		while(a<=5){
//			s = s+a;
//			a=a+2;	
//		}
//		System.out.println(s);
//		
	}

}
