package com.neusoft.test0712;

import java.util.Arrays;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Test9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * ���飺ͬһ�������ݵļ��ϡ�
 * ���������봴������һ��
 */
		int[] a = {6,4,5,6,9};
		double[] b = {6.1,4,5,6,9};
		
		System.out.println(a[2]);
		
		System.out.println("---------����Խ���쳣-------------");
		//����������ʼ��
		int[] c = new int[5];	
		//�Լ�ǿ�Ƴ�ʼ��
		int[] c1 = {1,2,3,4,5};
		System.out.println(c1[4]);
		//�����±�Խ���쳣
		//java.lang.ArrayIndexOutOfBoundsException
//		System.out.println(c1[5]);
		int[] c2 = new int[]{1,2,3,4,5};//д���������һ��
//		char d[] = {'a','b'};
		
		System.out.println("---------��������ֵ-------------");
		
		double[] e = new double[5];
		System.out.println("e[0]");
		
//		String ������null
		String[] f = new String[5];
		System.out.println(f[0]);
		
//		booleanΪflase
		boolean[] g = new boolean[5];
		System.out.println(g[0]);
		
		char[] h = new char[5];
		System.out.println(h[0]);
		
		System.out.println("------------����ı���----------");
		int[] l = {1,2,3,4,5,6,7};
		
//		1.forѭ��
		for(int i=0;i<5;i++){
			int k=l[i];
			System.out.print(k);	
		}
		
//		2.whileѭ��
		int j=0;
		while(j<5){
			System.out.println("���ֵ��Сֵ��"+a[j]);
			j++;
		}
//		3.foreachѭ��
		for(int n:l){
			System.out.println(n);
		}
		
		
		
		System.out.println();
		System.out.println("-------�ҳ����������ֵ����Сֵ----------");
		
		int max = l[0];
		int min = l[0];
		for(int n:l){
			if(n>max){
				max=n;
			}
			if(n<min){
				min=n;
			}
		}
		System.out.println(max);
		System.out.println(min);

//		int[] news = { 1, 3, 4, 5, 7, 8, 9, 11, 2, 6 };
//		for (int i = 0; i < news.length - 1; i++) {
//		   for (int j = i; j < news.length; j++) {
//		    if (news[i] > news[j]) {
//		     int temp = news[j];
//		     news[j] = news[i];
//		     news[i] = temp;
//		    }
//		   }
//		  }
//		  for (int i = 0; i < news.length; i++) {
//		   System.out.println(news[i]);
//		  }
		
		
		
		
		
		
		
		
		
	}

}
