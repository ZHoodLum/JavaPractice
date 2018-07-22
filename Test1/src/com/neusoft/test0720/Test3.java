package com.neusoft.test0720;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("请输入：");
		String a = s.next();
		System.out.println(a);
		
		String[] b = a.split(",");
		for(String n:b){
			System.out.println(n);
		}
		
		
//		System.out.println("Test.java".endsWith());
		
		
		
		
		
	}
}
