package com.neusoft.test0712;

import java.util.Scanner;

public class Htest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Scanner sc = new Scanner(System.in);
		for(;;){
			System.out.print("������ˮ�ɻ���ֵ��");
			int a = sc.nextInt();
			
			int b = a/100;
			System.out.println("��λ��Ϊ��"+b);
			int c = (a/10)%10;
			System.out.println("ʮλ��Ϊ��"+c);
			int d = a%10;
			System.out.println("��λ��Ϊ��"+d);
			
			 if((b*b*b+c*c*c+d*d*d)== a){
				 System.out.println();
				 System.out.println("ˮ�ɻ���Ϊ��"+a);
			 }else{
				 System.out.println("����ˮ�ɻ�����");
				 System.out.println();
			 }continue;
		}
	}

}
