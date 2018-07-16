package com.neusoft.test0716;

public class Test7 {
	//查看ClassA
	public static void main(String[] args) {
		
		//默认值都在堆内存当中 有虚拟机分配初始值
		ClassA c = new  ClassA();
		//对象名--->引用对内存当中分配的地址
		
		System.out.println(c.a);
		System.out.println(c.b);
		System.out.println(c.d);
		
		
		ClassA c2 = new ClassA();
		
		
		System.out.println("-----------------------");
		
		int[] a = new int[1];
		System.out.println(a[0]);
		
		boolean[] b = new boolean[1];
		System.out.println(b[0]);
		
		String[] d = new String[1];
		System.out.println(d[0]);
		
		System.out.println("-----------------------");
		
		ClassA c3 = new ClassA();
		System.out.println(c3.a);
		
		c3.method1();
		
		
		
		
	}
}
