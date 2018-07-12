package com.neusoft.test0712;

import java.util.Random;
import java.util.Scanner;

public class Htest6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1-100奇数相加
//		int s=0;
//		for(int a=1;a<100;a=a+2,a++){
//			s=s+a;
//		}
//		System.out.println(s);
//		
//		输入五个整数，并输出总和
//		Scanner sc = new Scanner(System.in);		
//		int s=0;
//		for(int i=1;i<=5;i++){
//			s=s+sc.nextInt();
//		}
//		System.out.println(s);
		
//		int a = s.nextInt();
//		int b = s.nextInt();
//		int c = s.nextInt();
//		int d = s.nextInt();
//		int e = s.nextInt();
//		int sum=a+b+c+d+e;
	
		
//		Random r = new Random();
		Scanner sc = new Scanner(System.in);		
		int s = sc.nextInt();
		int r=(int)(Math.random()*4);
		System.out.println(r);
		for(int i=1;i<3;i++){
			s=sc.nextInt();
		}
		if(s==r){
			System.out.println("猜对了");
		}else{
			System.out.println("猜错了");
		}
		
	}

}
