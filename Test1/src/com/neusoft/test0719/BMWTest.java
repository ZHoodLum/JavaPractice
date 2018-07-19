package com.neusoft.test0719;

public class BMWTest {
	public static void main(String[] args) {
		
		//普通
//		BMW320 b320 = new BMW320();
//		BMW523 b523 = new BMW523();
//		
		//用户提车  去工厂提车
		SimpleFactoryBMW simplefbmw = new SimpleFactoryBMW();
		
		//多态 父类引用指向类对象
//		Fu f = new Zi(); 上溯 f BMW
//		Zi z = f;下溯      BMW320 b1 = new (BMW320)BMW;
		
		BMW320 b1 = (BMW320)simplefbmw.makecar("BMW320");
		BMW320 b2 = (BMW320)simplefbmw.makecar("BMW320");
		BMW523 b3 = (BMW523)simplefbmw.makecar("BMW520");
		
	}
}
