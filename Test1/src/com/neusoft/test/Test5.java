package com.neusoft.test;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int a = 10;
//		int b = a++;
//		int c = (a>11) ? b:12;
//		System.out.println(b);
//		System.out.println(c);
		
//		控制台输入值
		int a = 0;
		int b = 0;
		int temp = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入a的值：");
		a = sc.nextInt();
		System.out.println("请输入b的值：");
		b = sc.nextInt();
		System.out.println("输入的a的值为"+a+"输入的b值为"+b);
		
		temp = a;
		a = b;
		b = temp;
		System.out.println("交换后：");
		System.out.println("输入的a的值为"+a+"输入的b值为"+b);
	}

}
