package com.neusoft.test0720;

public class Test1 {
	
	public static void main(String[] args) {
		String a = "abcde";
		char[] b = {'a','b','c','d','e'};
		
		String c1 = null;
		char[] c2 = new char[5];
		/**
		 * char ת��Ϊstring 
		 */
		//
		System.out.println("String���toCharArray()����");
		c2 = a.toCharArray();
		for(char n:c2){
			System.out.println("���N:"+n);
		}
		System.out.println();
		
		//
		System.out.println("����1  String���valueOf��char[]������");
		c1 = String.valueOf(b);
		System.out.println("ʹ��valueOf:"+c1);
		System.out.println();
		
		//
		System.out.println("String�Ĺ��췽�� new String (char[])");
		String c3 = new String(b);
		System.out.println(c3);
		
		//
		System.out.println("��ȡ�ַ���λ��");
		String c4 = new String(b,1,2);
		System.out.println(c4);
		System.out.println();
		
		
		//
		String c5 = 'a'+""+'b';
		System.out.println(c5);
		String c6 = "";
//		for(char)
		
		
		
		
		
	}
}
