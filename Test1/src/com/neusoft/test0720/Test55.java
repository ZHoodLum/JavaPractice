package com.neusoft.test0720;

public class Test55 {
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("asf");
		StringBuffer sb2 = new StringBuffer("asf");
		
		System.out.println(sb1.equals(sb2));
		
		//��toStringת������ ���бȽ�
		System.out.println(sb1.toString().equals(sb2.toString()));
		
	}
}
