package com.neusoft.test0711;

public class Test2 {
	
	public static void main(String[] args) {
		
		int a = 9;
		int b = 9/2;
		System.out.println(b);
		
//		float类型 需要在后面加f，否则认为是double类型         float 单精度 所占空间32位     double 双精度  所占空间64位
		float c = 9.0f/2;
		double d = 9.0/2;
		
		d = c;	//将c赋值给d
		c = (float)d;	//强制类型转换
		
		System.out.println(c);
		System.out.println(d);
		
//		------------
		int h=10;
		int j=h;
		System.out.println();
		
	}
}
