package com.neusoft.test0720;

public class Test4 {
	public static void main(String[] args) {
		
		//��String����ת��ΪStringBuffer����
		
		//����1 ���췽��StringBuffer(String s)
		String a = "abc";
		StringBuffer sb = new StringBuffer(a);
		sb.append("bcd");
		System.out.println(sb.toString());
		
		//����2 append(String s);
		StringBuffer sb1 = new StringBuffer();
		sb1.append(a);
		System.out.println(sb1);
		
		//Stringuffer
		//׷�ӷ���
		sb1.append("ghj");
		System.out.println(sb1);
		//���뷽��
		sb1.insert(2, "Jury");
		System.out.println(sb1);
		//ɾ������
		sb1.insert(2, 10);
		System.out.println(sb1);
		//��ѯ����
		int i = sb1.indexOf("b");
		System.out.println(sb1);
		//�޸ķ���
		sb1.replace(0, 2, "YYYOP");
		System.out.println(sb1);
		
		
		
		//StringBuffer����ת��ΪString����   ��StringBuffer��toString���� ����
		String b = sb.toString();
		System.out.println();
		
		
	}
}
