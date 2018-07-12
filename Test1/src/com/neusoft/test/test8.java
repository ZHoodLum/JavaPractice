package com.neusoft.test;

import java.util.Scanner;

public class test8 {
	public static void main(String[] args) {
		//取余数运算
		double q=1;
		double w =10;
		double e=3;
		q=w % e; //-10%-3  负数  10%-3   正数  ,根据前面的数进行取正负
		System.out.println(q);
		
		//运算符
		int a=2;
		a=a+2;
		a+=1;
		a++;
		++a;
//		a*=1;
//		a/=1;
//		a-=1;
		System.out.println(a);
	
		//两个正整数相加，如果是奇数输出1，如果是偶数 输出2
		Scanner sa = new Scanner(System.in);
		int n=0,n1=0,n2=0;
		System.out.println("请输入两个正整数：");
		n1=sa.nextInt();
		n2=sa.nextInt();
		
		//使用三目运算法
		n= (n1+n2%2==0)?2:1;
		System.out.println(n);
		
		//使用if else
		n=n1+n2%2;
		if(n==0) {
			System.out.println("2");
		}else {
			System.out.println("1");
		}
		
		
	}
}
