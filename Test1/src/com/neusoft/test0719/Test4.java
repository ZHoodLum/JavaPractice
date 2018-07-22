package com.neusoft.test0719;

public class Test4 {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		
		String s3 = new String("abc");
		String s4 = new String("abc");
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
		System.out.println("----------");
		System.out.println(s1==s4);
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		
		System.out.println("----------");
		String s5 = s1.toUpperCase();
		System.out.println(s5);
		System.out.println(s1.equals(s5));
		System.out.println(s1==s5);
		
		
	}
}
