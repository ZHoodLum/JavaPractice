package com.neusoft.test0717;

public class GG {
	public int a ;
	public static int b;
	
	public void method1(){
		System.out.println(a);
		System.out.println(b);
	}
	/**
	 * ��ͨ�ķ���  �ڲ������ʵ��ʱ�����˶�����ܵ��ã�
	 * ͨ����������.��ȥ����
	 * 
	 * ��ͨ�ķ������Ե���static������static���εı�����������
	 */
	public void method2(){
		method1();
	}
	/**
	 * ��static���εķ��� ���γ�֮Ϊ�෽��
	 * 
	 * ��static���εķ��� ���Ե���������static  ���ε�����
	 * ��static���εķ���  ֻ�ܵ���������static  ���εķ�����������
	 */
	public static void method3(){
		System.out.println(b);
		//System.out.println(a);����
	}
	
	/**
	 * ��static���εķ������Ե������� ��static���ε�����
	 * ��Ϊ���Ƕ������ص���̬������  ����ֱ��ͨ��(����.)ȥ����
	 * 
	 */
	public static void method4(){
		method3();
//		method1();
	}
	
}
