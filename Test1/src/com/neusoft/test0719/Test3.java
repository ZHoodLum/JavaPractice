package com.neusoft.test0719;

public class Test3 {
	public static void main(String[] args) {
		
		//������ǰ�װ���ͳ��ȣ��������һ�����ֵ����Сֵ
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		
		System.out.println(Short.MAX_VALUE);
		
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);

		
		//����ת��
		int a=10;
		Integer a1 = new Integer(a);
		System.out.println(a1);
		
		Integer a2 = new Integer("9999");
		//Integer ��valueof �������Խ�������������    ת��Ϊ�Լ���Integer��������
		Integer a4 = Integer.valueOf("99");
		System.out.println(a4);
		
		//Integer��intValue()������longValue��������ת��Ϊ  ���Լ�ת��Ϊ��Ӧ����������
		int a6 = a2.intValue();
		long a7 = a2.longValue();
		System.out.println(a6+",,,,"+a7);
		
		
		//
		int b1 = 10;
		/**
		 * Integer b2=b1;
		 * �ӻ�����������   ֱ��ת��Ϊ��װ��������  �����Զ�װ��
		 * 
		 * int b3=b2;
		 * �Ӱ�װ��������   ֱ��ת��Ϊ������������   �����Զ�����
		 */
		Integer b2=b1;
		int b3=b2;
		
		
		
		
	}
}
