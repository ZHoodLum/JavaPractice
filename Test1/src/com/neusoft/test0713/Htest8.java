package com.neusoft.test0713;

import java.util.Scanner;

public class Htest8 {
	public static void main(String[] args) {
//		������λ����1234  ���з�ת  4321
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int sum=0;
		
		while(a!=0){
			/*
			 * 12
			 * 2  10
			 */
			sum = a%10+sum*10;
			a = a/10;
		}
		System.out.println(sum);
	}
}
