package com.neusoft.test0711;

public class Test2 {
	
	public static void main(String[] args) {
		
		int a = 9;
		int b = 9/2;
		System.out.println(b);
		
//		float���� ��Ҫ�ں����f��������Ϊ��double����         float ������ ��ռ�ռ�32λ     double ˫����  ��ռ�ռ�64λ
		float c = 9.0f/2;
		double d = 9.0/2;
		
		d = c;	//��c��ֵ��d
		c = (float)d;	//ǿ������ת��
		
		System.out.println(c);
		System.out.println(d);
		
//		------------
		int h=10;
		int j=h;
		System.out.println();
		
	}
}
