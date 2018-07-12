package com.neusoft.test0712;

import java.util.Random;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		根据控制台输入判断天数
//		Scanner s = new Scanner(System.in);
		System.out.println("请输入1-12月份：");
//		int a = s.nextInt();
//		 if(a==1||a==3||a==5||a==7||a==8||a==10||a==12){
//			 System.err.println("该月的天数为31");
//		 }else if(a==2){
//			 System.out.println("该月的天数为28");
//		 }else if(a==4||a==6||a==9||a==11){
//			 System.out.println("该月的天数为30");
//		 }
		
//		随机选取月份 进行判断
		Random r = new Random();
		System.out.println("随机选取1-12月份：");
		int a = r.nextInt(12);
		a = a+1;
		if(a==1||a==3||a==5||a==7||a==8||a==10||a==12){
			 System.err.println("该月的天数为31");
		 }else if(a==2){
			 System.out.println("该月的天数为28");
		 }else if(a==4||a==6||a==9||a==11){
			 System.out.println("该月的天数为30");
		 }else{
			 System.out.println("月份输入有误！");
		 }
	}

}
