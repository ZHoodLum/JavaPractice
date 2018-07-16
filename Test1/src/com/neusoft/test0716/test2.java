package com.neusoft.test0716;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int sum=0;
		while(a!=0){
			sum = a%10+sum*10;
			a = a/10;
		}
		System.out.println(sum);
	}

}
