package com.neusoft.test0713;

import java.util.Scanner;

public class Htest6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		Scanner s = new Scanner(System.in);
//		int a = s.nextInt();

//			 求大于200的最小质数
			boolean f = true;
			for(int i=200;;i++) {
				for(int j=2;j<i;j++) {
					if(i%j == 0) {
						//如果找到一个i能被j整除，则不是质数
						f = false;
//						break;
					}
				}
				if(f) {
					System.out.println("大于200的最小质数："+i);
					break;
				}
				f = true;
			}
			

	}

}
