package com.neusoft.test0712;

import java.util.Scanner;

public class Htest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������һ������������");
		for(;;){
			Scanner s = new Scanner(System.in);
			int a = s.nextInt();
			
			if(90<=a&&a<=100){
				System.out.println("A��!");
			}
			if(80<=a&&a<=89){
				System.out.println("B��!");
			}
			if(70<=a&&a<=79){
				System.out.println("C��!");
			}
			if(60<=a&&a<=69){
				System.out.println("D��!");
			}else{
				System.out.println("E��");
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
