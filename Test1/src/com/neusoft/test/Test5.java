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
		
//		����̨����ֵ
		int a = 0;
		int b = 0;
		int temp = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("������a��ֵ��");
		a = sc.nextInt();
		System.out.println("������b��ֵ��");
		b = sc.nextInt();
		System.out.println("�����a��ֵΪ"+a+"�����bֵΪ"+b);
		
		temp = a;
		a = b;
		b = temp;
		System.out.println("������");
		System.out.println("�����a��ֵΪ"+a+"�����bֵΪ"+b);
	}

}
