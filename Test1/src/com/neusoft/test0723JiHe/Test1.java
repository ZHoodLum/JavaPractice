package com.neusoft.test0723JiHe;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		
		
		int[] a = {12,23,34,53,6};
		//��ν����������·���һ���ڴ�ռ�
		System.out.println("old  "+a.length);
		System.out.println(a);
		
		int[] b = {12,23,34,53,6};
		System.out.println(b.length);
		
		a = Arrays.copyOf(a, 10);
		System.out.println("new  "+a.length);
		System.out.println(a);

		/**
		 * �����п�������
		 * a Դ���� ԭ�����еĿ�ʼλ��
		 * b Ŀ������  Ŀ������Ŀ�ʼλ��  
		 * �������� 
		 */
		System.arraycopy(a, 0, b, 0, 5);
		
		for(int n:a){
			System.out.println(n);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
