package com.neusoft.test0718;

public class BBTest {
	
	public static void main(String[] args) {
		BB b1 = BB.getInstance();
		BB b2= BB.getInstance();
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b1==b2);
	}
}
