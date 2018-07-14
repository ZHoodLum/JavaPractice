package com.neusoft.test0713;

import java.util.Scanner;

public class Htest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("请输入两位整数：");
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int y = s.nextInt();
		add(x, y);
	}
	
	public static void add(int x,int y){
		System.out.println(x+y);
	}
	
}
