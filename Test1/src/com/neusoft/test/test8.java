package com.neusoft.test;

import java.util.Scanner;

public class test8 {
	public static void main(String[] args) {
		//ȡ��������
		double q=1;
		double w =10;
		double e=3;
		q=w % e; //-10%-3  ����  10%-3   ����  ,����ǰ���������ȡ����
		System.out.println(q);
		
		//�����
		int a=2;
		a=a+2;
		a+=1;
		a++;
		++a;
//		a*=1;
//		a/=1;
//		a-=1;
		System.out.println(a);
	
		//������������ӣ�������������1�������ż�� ���2
		Scanner sa = new Scanner(System.in);
		int n=0,n1=0,n2=0;
		System.out.println("������������������");
		n1=sa.nextInt();
		n2=sa.nextInt();
		
		//ʹ����Ŀ���㷨
		n= (n1+n2%2==0)?2:1;
		System.out.println(n);
		
		//ʹ��if else
		n=n1+n2%2;
		if(n==0) {
			System.out.println("2");
		}else {
			System.out.println("1");
		}
		
		
	}
}
