package com.neusoft.test0713;

import java.util.Scanner;

public class Test6 {
/**
 * 
 * @param args
 */
	/*
	 * �β���ʵ��   Ҳ�������Ϊ ����ı���  int i �� ����ʵ���� i=10
	 * �β���ʵ�� ����һ�¡� ����һ��
	 * return  ����ֵ ˭����  ����˭	
	 * 
	 * �������ࣺ
	 * 		1�����ݲ����������ࣺ    �вη���  ��8���������� ��������������  ���޲η��� ��
	 * 		2�����ݷ���ֵ���ͷ��ࣺ   �з���ֵ����������ֵ����Ϊ�����������͡������������ͣ�
	 * 							�޷���ֵ����������ֵ����ʹ��void�ؼ���
	 * 
	 * ���������ظ�����
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int c = add(1,2);//�����ĵ���
//		System.out.println(c);
//		
//		int d = methoda();//�����ĵ���
//		System.out.println(d);
//		
//		double e = methodb();//�����ĵ���
//		System.out.println(e);
//		
//		String f = methodc("ssssss");//�����ĵ���
//		System.out.println(f);
//
//		method();
		add();
		
	}
	
	
//	����
	
//	public static int add(int a ,int b){
//		
//		return a+b;//����ֵ ˭����  ����˭		
//	}
//	
//	public static int methoda(){
//		return 10;	
//	}
//	
//	public static double methodb(){
//		return 99.0;	
//	}
//	public static String methodc(String a ){
//		return a;
//	}
//	public static void method(){
//		System.out.println("������method������");
//		
//	}
	public static void add(){
		double a=0,b=0,c=0;
		double r=1;
		Scanner sa = new Scanner(System.in);
		
		System.out.println("������һ������");
		a=sa.nextDouble(); 
		
		System.out.println("������һ���������");
		String s = sa.next();
		
		System.out.println("������һ������");
		b=sa.nextDouble();

		for(int i=0;i<=s.length()-1;i++) {
			if(s.equals("+")) {
				System.out.println("����+�ã�"+(c=a+b));
			}else if(s.equals("-")){
				System.out.println("����-�ã�"+(c=a-b));
			}else if(s.equals("*")){
				System.out.println("����*�ã�"+(c=a*b));
			}else if(s.equals("/")){
				if(b==0){
					System.out.println("��������Ϊ0��");
//					System.exit(0);
				}else{
				System.out.println("����/�ã�"+(c=a/b));
				}
			}
		}
	}
	
	
}
