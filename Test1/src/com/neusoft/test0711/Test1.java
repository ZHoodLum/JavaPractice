package com.neusoft.test0711;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		左右括号
		System.out.println("您好！");
//		可以改变的量，叫变量
		byte a = 10;
		System.out.println(a);
//		反码 补码 源码
		byte a1 = 127;
		a1= (byte) (a1+1);
//		如果为1000 0000  代表-128 
		System.out.println(a1);
		
//		移位运算
		byte b = 1;
		System.out.println(b<<1);
		byte c = 127;
//		进行移位运算的时候，Java虚拟机会将byte short变为Int类型 >>  <<
		System.out.println(c>>1);
		
//		8进制 16进制
		int d = 010;
		System.out.println(d);
//		逢16进1
		int f = 0x10;
		System.out.println(f);
		
		int h = 10;
//		int h = 128; 输出时超出byte范围
		byte i = 1;
//		整数类型 byte short int long
		i =(byte) h; //需要进行强制类型转换  小的容器装大的东西
					//int 类型强制转换为byte类型
//		h = i;
		System.out.println(i);
		
		
		
	}

}
