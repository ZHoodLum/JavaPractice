package com.neusoft.test0711;

import java.util.Scanner;

public class practice1 {
	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		
		
		String a;
		System.out.println("请输入字符的值：");
		a = sc.next();
		
		System.out.println("将字符转换为大写字符："+a.toUpperCase());
	
		System.out.println("将字符转换为小写字符："+a.toLowerCase());
	}

	
}
