package com.neusoft.test0718;

public class Test5 {
	
	
	public static void main(String[] args) {
		Fu f1 = new Fu();
		
		Zi z1 = new Zi();//�������� ָ���� �Լ�����ָ���Լ�
//		z1.method1();
		
//		z1.method2();
		
		
		Fu fz = new Zi();//��������ָ���������---->��̬
		fz.method1();//�����һ������ ��ֻ�ܵ������Լ����еķ���
		if(fz instanceof Zi){
			System.out.println("fi��zi��");
		}
		if(fz instanceof Zi2){
			System.out.println("fi��zi2��");
		}
		//		fz.method2();
		
		/**
		 * ����ת�� ǰ����֮ǰ����������ת�Ͳ�������ת�͡�
		 */
		Zi zfz = (Zi)fz;
		
	}
}
