package com.neusoft.test0717;

public class GGTest {
	public static void main(String[] args) {
		
		GG g1 = new GG();
		g1.a=10;
		
		/**
		 * ��static���ε����Ժͷ��� 
		 * (������.)ȥ����   ���Ƽ�
		 * (����.)ȥ����       �Ƽ�
		 */
		g1.b=10;
		g1.method1();
		System.out.println("------------------------");
		//����1 a=0 b=0      a��
		GG g2 = new GG();
		g2.method1();
		
	}
}
