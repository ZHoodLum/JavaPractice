package com.neusoft.test;

import java.util.Random;
import java.util.Scanner;
import java.math.BigInteger;

public class Test7 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//����+-*/ ���Ŷ� ������������
//		���ݻ�������
//		byte short int long
//		float double
//		char
//		boolean
		
		
//		������������ -->��������������
//		������������--> �ǻ�����������
		
		
		//ʹ��forѭ��ʵ�� + - * /
//		String[] op = {"+","*","-","/"};
//		char[] op = new char[] {'+','-','*','/'};
		
		double a=0,b=0,c=0;
		int r=1;
		Scanner sa = new Scanner(System.in);
		System.out.println("��������������");
		a=sa.nextDouble(); //ֹͣ�������У����ҵȴ��û��ڿ���̨����a��ֵ
		b=sa.nextDouble();
		System.out.println("������һ���������");
		
		char[] s = new Scanner(System.in).next().toCharArray();
//		int s = radom.nextInt(1);
//		System.out.println("�����ȡ���������λ����"+s);
		for(int i=0;i<=s.length-1;i++) {
			if(s[i] == '+') {
				System.out.println("����ã�"+(c=a+b));
			}else if(s[i] == '-'){
				System.out.println("����ã�"+(c=a-b));
			}else if(s[i] == '*'){
				System.out.println("����ã�"+(c=a*b));
			}else if(s[i] == '/'){
				System.out.println("����ã�"+(c=a/b));
			}
			else {
//				System.out.println(new BigInteger(a+"").pow(b));
				for(int j=0;j<b;j++) {
				 r = (int) (r *a);//��j����1 ����r= r*a ����j<b   ������һ�ν�������r*a(rΪ��һ�������)
				 System.out.println("����ã�"+r);
				}
			}
			
		}
			
	}

}
