package com.neusoft.test0711;

import java.util.Random;
import java.util.Scanner;
import java.math.BigInteger;

public class Test7 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//根据+-*/ 符号对 进行正数运算
//		数据基本类型
//		byte short int long
//		float double
//		char
//		boolean
		
		
//		基本数据类型 -->非引用数据类型
//		引用数据类型--> 非基本数据类型
		
		
		//使用for循环实现 + - * /
//		String[] op = {"+","*","-","/"};
//		char[] op = new char[] {'+','-','*','/'};
		
//     8种数据类型 判断相等  == 
//		String 判断相等用euqals
		
		
		double a=0,b=0,c=0;
		int r=1;
		Scanner sa = new Scanner(System.in);
		System.out.println("请输入两个数：");
		a=sa.nextDouble(); //停止向下运行，并且等待用户在控制台输入a的值
		b=sa.nextDouble();
		System.out.println("请输入一个运算符：");
		
		char[] s = new Scanner(System.in).next().toCharArray();
//		int s = radom.nextInt(1);
//		System.out.println("随机抽取到的运算符位数："+s);
		for(int i=0;i<=s.length-1;i++) {
			if(s[i] == '+') {
				System.out.println("运算得："+(c=a+b));
			}else if(s[i] == '-'){
				System.out.println("运算得："+(c=a-b));
			}else if(s[i] == '*'){
				System.out.println("运算得："+(c=a*b));
			}else if(s[i] == '/'){
				if(b==0){
					System.out.println("除数不能为0！");
				}else{
				System.out.println("运算/得："+(c=a/b));
				}
			}
			else {
//				System.out.println(new BigInteger(a+"").pow(b));
				for(int j=0;j<b;j++) {
				 r = (int) (r *a);//当j等于1 进行r= r*a 由于j<b   所以再一次进行运算r*a(r为第一次运算的)
				 System.out.println("运算得："+r);
				}
			}
			
		}
	}

}
