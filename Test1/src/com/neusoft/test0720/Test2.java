package com.neusoft.test0720;

public class Test2 {
	public static void main(String[] args) {
		
		String a = "asdfghjkldf";
		//��ӡm-n��  ������� - ǰ�����
		System.out.println(a.substring(1,2));
		
		System.out.println(a.indexOf("df"));
		//��(3)ĳ������ ��������
		System.out.println(a.indexOf("df",3));
		
		//String.trim() ȥ���ո�
		String b = "  ff  ff af  afa ";
		String b1 = "fa";
		String b2 = "  ff";
		
		System.out.println(b.trim());
		System.out.println(b1.trim());
		System.out.println(b2.trim());
		
		
		
		
		
		
		
	}
}
