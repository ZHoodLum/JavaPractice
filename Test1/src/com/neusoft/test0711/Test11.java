package com.neusoft.test0711;

import java.util.Scanner;

public class Test11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0,b=0,c=0;
		Scanner sa = new Scanner(System.in);
		System.out.println("��������������");
		a=sa.nextInt(); //ֹͣ�������У����ҵȴ��û��ڿ���̨����a��ֵ
		b=sa.nextInt();
		
		System.out.println("������һ���������");
//		char[] s = new Scanner(System.in).next().toCharArray();
		String s = sa.next();
		switch(s){
		case "+":System.out.println(a+b);break;
		case "-":System.out.println(a-b);break;
		case "*":System.out.println(a*b);break;
		case "/":System.out.println(a/b);break;
		default:System.out.println(a%b);
		}
	}

}
