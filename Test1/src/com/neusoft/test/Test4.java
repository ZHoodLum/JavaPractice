package com.neusoft.test;

public class Test4 {
	
	public static void main(String[] args) {
		
//		����� + - * /
		double a = 10/3;	//�ó����Ľ��  3.33333333335 java���Ե�ȱ�� ���ܹ�׼ȷ�ļ���  ����������Ŀ
		int b = 10+3;
		int c = 10-3;
		int d = 10*3;
		
		System.out.println(a);
		
//		++e ������ �����  �� �Ƚ��мӼ�
//		e++ ��ʹ�� ������  ����ʹ��������
//		e = e+1;  e++;        e+=1;
//		e--;      e -=1;    e =e-1;
//		e *= 1;
//		e /- 1;
		
		
//		�߼������  || ��  һ������, && ��  һ�����,  ! ��  �ߵ��Ƿ�
//		| ��λ��   ��Ҫ��������������Ϊ�� �ſ���ͨ��
		System.out.println( !(2<5) );
		
		
		
//		���������   ��Ŀ�����
		boolean n = (4 < 3) ? true :false;
		System.out.println(n);
		
		
		int a1 = 0,a2 = 6;
//		a1    ��a2 ����5�������ж� ��  ���Ϊ10 ,����Ϊa1.
		a1 = (a2>5) ? 10:a1;
		
		System.out.println(a1);
		
		
		int x = 1 , y = 2 , z = 3;
		y+=z--/++x;
		System.out.println(y);
		
		
		
		
		
		
	}
}
