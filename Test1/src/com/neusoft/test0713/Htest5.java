package com.neusoft.test0713;

import java.util.Random;
import java.util.Scanner;

public class Htest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����������λ������");
//		Random r = new Random();
//		int a = r.nextInt();
//		System.out.println("����A��ֵΪ��"+a);
//		int b = r.nextInt();
//		System.out.println("����B��ֵΪ��"+b);
		
		int a = new Random().nextInt(10) + 1;
		System.out.println("����A��ֵΪ��"+a);
		int b = new Random().nextInt(10) + 1;
		System.out.println("����B��ֵΪ��"+b);
		
		int c = add(a,b);
		System.out.println("��λ����ӵ��ڣ�"+c);
	}
	
	public static int add(int x,int y){
		return x+y;
	}

}
