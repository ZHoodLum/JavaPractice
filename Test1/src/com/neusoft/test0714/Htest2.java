package com.neusoft.test0714;

import java.util.Random;

public class Htest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����1-16
		int blueball = suiji(1,16);
		//���� 6��  �����ظ�  ��Χ 1-33
		int[] a = new int[6];
		shuzu(a);
		
		//����н�����
		System.out.println("����Ϊ��"+blueball);
		System.out.print("����Ϊ��");
		bianliArray(a);
		
		
	}
	public static int suiji(int n,int m){
		Random r = new Random();
		
//		1-10֮�����
//		int k = r.nextInt(10)+1;
//		5-8֮�����
//		int k1 = r.nextInt(8-5+1)+5;
//		n-m֮�����
		int k2 = r.nextInt(m-n+1)+n;
		return k2;
		
	}
	/*
	 * ��������
	 * ����Χ 1-33
	 * Ҫ����������װ��6�������  ��Χ��1-33�����Ҳ��ظ�
	 * 
	 */
	
	public static void shuzu(int[] a){	
		Random r = new Random();
		int[] redballArray = new int[6];
//		for(int i=0;i<6;i++){
//			
//		}
		
	}
	//�������� ���ڱ�������
	public static void bianliArray(int[] a){
		System.out.println("����Ϊ��");
		for(int n:a){
			System.out.print(n+" ");
		}
		System.out.println();
	}
		
}
