package com.neusoft.test0713;

public class Test7 {

	public static void main(String[] args) {
		//method1
		int b= 10;//��ο�����method1��ʹ���أ�ͨ����������  �����ʵ�� ���������е��β�
		method1(b);
		System.out.println("**********************************");
		//method2
		method2(9999);//�������β���ʵ�θ��������� һ�²��ܵ��õ�ǰ����
		System.out.println("**********************************");
		//method3
		int d=666;
		method3(d);
		
	}
	
	public static void method1(int x){
		
		//�ڷ����еı��� ��֮Ϊ�ֲ����� ֻ�޵�ǰ������ʹ�� ��רҵ���ʣ�������ǰ����������
		int a = 10;
		System.out.println(a);
		System.out.println("�����ơ�����");
	}
	
	public static void method2(int c){
		System.out.println(c);
	}
	
	public static void method3(int d){
		d=99;
		System.out.println(d);
		
	}
	
}
