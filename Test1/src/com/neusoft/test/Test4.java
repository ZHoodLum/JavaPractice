package com.neusoft.test;

public class Test4 {
	
	public static void main(String[] args) {
		
//		运算符 + - * /
		double a = 10/3;	//得出来的结果  3.33333333335 java语言的缺点 不能够准确的计算  比如银行项目
		int b = 10+3;
		int c = 10-3;
		int d = 10*3;
		
		System.out.println(a);
		
//		++e 先运算 在输出  ； 先进行加减
//		e++ 先使用 在运算  ；先使用在运算
//		e = e+1;  e++;        e+=1;
//		e--;      e -=1;    e =e-1;
//		e *= 1;
//		e /- 1;
		
		
//		逻辑运算符  || 或  一真则真, && 与  一假则假,  ! 非  颠倒是非
//		| 暗位或   需要两个或多个条件都为真 才可以通过
		System.out.println( !(2<5) );
		
		
		
//		条件运算符   三目运算符
		boolean n = (4 < 3) ? true :false;
		System.out.println(n);
		
		
		int a1 = 0,a2 = 6;
//		a1    对a2 大于5语句进行判断 ？  真就为10 ,否则为a1.
		a1 = (a2>5) ? 10:a1;
		
		System.out.println(a1);
		
		
		int x = 1 , y = 2 , z = 3;
		y+=z--/++x;
		System.out.println(y);
		
		
		
		
		
		
	}
}
