package com.neusoft.test0712;

import java.util.Random;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		���ݿ���̨�����ж�����
//		Scanner s = new Scanner(System.in);
		System.out.println("������1-12�·ݣ�");
//		int a = s.nextInt();
//		 if(a==1||a==3||a==5||a==7||a==8||a==10||a==12){
//			 System.err.println("���µ�����Ϊ31");
//		 }else if(a==2){
//			 System.out.println("���µ�����Ϊ28");
//		 }else if(a==4||a==6||a==9||a==11){
//			 System.out.println("���µ�����Ϊ30");
//		 }
		
//		���ѡȡ�·� �����ж�
		Random r = new Random();
		System.out.println("���ѡȡ1-12�·ݣ�");
		int a = r.nextInt(12);
		a = a+1;
		if(a==1||a==3||a==5||a==7||a==8||a==10||a==12){
			 System.err.println("���µ�����Ϊ31");
		 }else if(a==2){
			 System.out.println("���µ�����Ϊ28");
		 }else if(a==4||a==6||a==9||a==11){
			 System.out.println("���µ�����Ϊ30");
		 }else{
			 System.out.println("�·���������");
		 }
	}

}
