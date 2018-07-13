package com.neusoft.test0712;

import java.util.Scanner;

public class Htest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入一个整数分数：");
		for(;;){
			Scanner s = new Scanner(System.in);
			int a = s.nextInt();
			
			if(90<=a&&a<=100){
				System.out.println("A级!");
			}
			if(80<=a&&a<=89){
				System.out.println("B级!");
			}
			if(70<=a&&a<=79){
				System.out.println("C级!");
			}
			if(60<=a&&a<=69){
				System.out.println("D级!");
			}else{
				System.out.println("E级");
			}
		}
		/*		
		int c=66;
		int j=c/10;
		switch(j){
		case 10:System.out.println("A");
		case 9:System.out.println("A");
		case 8:System.out.println("A");
		}
	*/	
	}

}
