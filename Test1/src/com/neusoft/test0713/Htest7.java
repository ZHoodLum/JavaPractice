package com.neusoft.test0713;

import java.util.Scanner;

public class Htest7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//�����������˰,3500,5000,3500��5000˰�����,����˰ǰ���� ��ʾ˰����  ��ʾ���˶���˰
		
//�ɿ۳��ĳɱ�=���ܳɱ����/��1+6%��*0.06
//�����˰��=������˰����-�ɿۼ��ɱ���/��1+˰�ʣ�*˰��-�ɵֿ۵Ľ���˰
		
		Scanner s = new Scanner(System.in);
		double money = s.nextDouble();
		
		double l=money/(1+0.06)*0.06;
		System.out.println("�ɿۼ��ɱ���  "+l);
		double num = (money-l)/(1+0.06)*0.06;
		System.out.println("�����˰� "+num);
		
	}

}
