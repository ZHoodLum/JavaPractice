package com.neusoft.test0719;

public class BMWTest {
	public static void main(String[] args) {
		
		//��ͨ
//		BMW320 b320 = new BMW320();
//		BMW523 b523 = new BMW523();
//		
		//�û��ᳵ  ȥ�����ᳵ
		SimpleFactoryBMW simplefbmw = new SimpleFactoryBMW();
		
		//��̬ ��������ָ�������
//		Fu f = new Zi(); ���� f BMW
//		Zi z = f;����      BMW320 b1 = new (BMW320)BMW;
		
		BMW320 b1 = (BMW320)simplefbmw.makecar("BMW320");
		BMW320 b2 = (BMW320)simplefbmw.makecar("BMW320");
		BMW523 b3 = (BMW523)simplefbmw.makecar("BMW520");
		
	}
}
