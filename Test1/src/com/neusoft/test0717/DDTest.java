package com.neusoft.test0717;

public class DDTest {
	public static void main(String[] args) {
		//��ʵ���������ĺͲ����
		int a=5;
		int b=10;
		DD dd = new DD();
		
		
		System.out.println(dd.add1(a, b));
		
		System.out.println(dd.add2(a, b));
		//ʵ���������͵�2��
		System.out.println(dd.add3(a, b));
		/**
		 * ��c����Ϊ  int c=2;
		 * �����������©   ��Ϊ����������������
		 * dd.c=3;
		 * System.out.println(dd.add3(a, b));
		 */
		//����private  ֻ���ڵ�ǰ��  �ڲ�����
		System.out.println(dd.add3(a, b));
		
		
		/**
		 * 
		 */
		
		
		
		
		
	}
}
