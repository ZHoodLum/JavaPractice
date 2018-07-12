package com.neusoft.test0712;

import java.util.Random;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int a = r.nextInt(10);
		//随机2-10位数
		int b = r.nextInt(9)+2;
		System.out.println(b);
		
//		(0,1)
		double c = r.nextDouble();
		System.out.println(c);
		
//		[1,100]
		double d = r.nextDouble()*99+1;
		System.out.println(d);
		
//		math
		System.out.println("使用math输出");
		int g = (int) (Math.random()*3+1);
		System.out.println(g);
		
//		随机1-12随机数
		System.out.println(g);
//		0-11
		int a1 = r.nextInt(12);
		
		a1 = a1+1;
	}

}
