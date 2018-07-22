package com.neusoft.test0719;

public class Test3 {
	public static void main(String[] args) {
		
		//如果忘记包装类型长度，试着输出一下最大值与最小值
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		
		System.out.println(Short.MAX_VALUE);
		
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);

		
		//类型转换
		int a=10;
		Integer a1 = new Integer(a);
		System.out.println(a1);
		
		Integer a2 = new Integer("9999");
		//Integer 的valueof 方法可以将其他数据类型    转换为自己的Integer数据类型
		Integer a4 = Integer.valueOf("99");
		System.out.println(a4);
		
		//Integer的intValue()或者是longValue方法可以转换为  将自己转换为对应的数据类型
		int a6 = a2.intValue();
		long a7 = a2.longValue();
		System.out.println(a6+",,,,"+a7);
		
		
		//
		int b1 = 10;
		/**
		 * Integer b2=b1;
		 * 从基本数据类型   直接转换为包装数据类型  叫做自动装箱
		 * 
		 * int b3=b2;
		 * 从包装数据类型   直接转换为基本数据类型   叫做自动拆箱
		 */
		Integer b2=b1;
		int b3=b2;
		
		
		
		
	}
}
