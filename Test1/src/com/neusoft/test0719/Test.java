package com.neusoft.test0719;

public class Test {
	public static void main(String[] args) {
		
		/**
		 * 简单工厂与工厂模式
		 * 简单工厂 一个工厂根据逻辑判断产生多个产品
		 * 工厂模式  不同的工厂产生不同的产品   保证一个工厂只产生一个产品
		 * 
		 * 使用工厂模式 就可以降低耦合性  高内聚低耦合
 		 */
		
		FactoryBMW320 fb320 =new FactoryBMW320();
//		BMW320 b1 = (BMW320) fb320
	}
}
