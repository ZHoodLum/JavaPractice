package com.neusoft.test0713;

import java.util.Scanner;

public class Htest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("��������λ������");
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		
		int c = add(a,b);
		System.out.println("��λ����ӵ��ڣ�"+c);
	}
	
	public static int add(int x,int y){
		return x+y;
	}
	
}
