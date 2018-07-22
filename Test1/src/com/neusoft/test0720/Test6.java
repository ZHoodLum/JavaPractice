package com.neusoft.test0720;

import java.util.Scanner;

public class Test6 {
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("«Î ‰»Î£∫");
		String s1 = s.next();
		
		StringBuffer s2 = new StringBuffer(s1);
		
		s2.replace(3, 7, "****");
		System.out.println(s2);
		
		
		//
//		String s3=null;
//		char[] c1 = s1.toCharArray();
//		for(int i=0;i<c1.length;i++){
//			if(i>2&&i<=6){
//				s3=s3+"*";
//
//			}else{
//				s3=s3+c1[i];
//			}
//		}
//		System.out.println(s3);
		
		
	}
}
