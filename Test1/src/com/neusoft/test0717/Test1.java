package com.neusoft.test0717;

public class Test1 {
	//�������ջ���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AA aa = new AA();//���췽�� �����ǵ�new �������� ʱ���Ѿ�������
		System.out.println("------------");
		BB bb = new BB();//new �Ǹ��� �͵����Ǹ���Ĺ��췽��
		System.out.println("------------");
		CC cc = new CC(6);
		//�����ǰ���Ѿ������вι�����������Ҫ��ʾ��д�ղι��죬����new�ղι���ʱ����
		System.out.println("------------");
		CC cc1 = new CC();
		
		/**
		 * �������أ�ֻ�� 1����������  2�����������й�
		 * 
		 * ���췽��Ҳ���Խ������� ��ֻ�� 1����������  2�����������й�
		 */
		System.out.println("------------");
		CC cc3 = new CC("aaa");
		System.out.println("------------");
		cc3.cc();//��ͨ�ķ���
		System.out.println("------------");
		cc3.method3();
		System.out.println("------------");
		/**
		 * �ֲ���������ȫ�ֱ�������Ա������
		 */
		cc3.method2();
		System.out.println("------------");
		cc3.method1(1);
		System.out.println("------------");
		cc3.method4();
		System.out.println(cc3.a);
		System.out.println("---ʹ��this�����ֳ�Ա��ֲ�����-----");
		cc3.method5(6666);
		System.out.println(cc3.a);
	}

}
