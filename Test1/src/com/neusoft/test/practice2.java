package com.neusoft.test;

public class practice2 {
	public static void main(String args[]) {
		double f = 110;
		double c = 37;
		System.out.println("���϶ȱ�����϶�:" + (f - 32.0)*5/9);
		System.out.println("���϶ȱ�ɻ��϶�" + c*9.0/5+32);
		System.out.println("\n");
		System.out.println("���϶ȱ�����϶�:" + String.format("%.2f", (f - 32.0)*5/9));//����С�������λ
		System.out.println("���϶ȱ�����϶�:" + String.format("%.2f",  c*9.0/5+32));//����С�������λ
		
		
	}
}
