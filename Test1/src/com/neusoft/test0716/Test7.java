package com.neusoft.test0716;

public class Test7 {
	//�鿴ClassA
	public static void main(String[] args) {
		
		//Ĭ��ֵ���ڶ��ڴ浱�� ������������ʼֵ
		ClassA c = new  ClassA();
		//������--->���ö��ڴ浱�з���ĵ�ַ
		
		System.out.println(c.a);
		System.out.println(c.b);
		System.out.println(c.d);
		
		
		ClassA c2 = new ClassA();
		
		
		System.out.println("-----------------------");
		
		int[] a = new int[1];
		System.out.println(a[0]);
		
		boolean[] b = new boolean[1];
		System.out.println(b[0]);
		
		String[] d = new String[1];
		System.out.println(d[0]);
		
		System.out.println("-----------------------");
		
		ClassA c3 = new ClassA();
		System.out.println(c3.a);
		
		c3.method1();
		
		
		
		
	}
}
