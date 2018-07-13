package com.neusoft.test0713;

import java.util.Scanner;

public class Htest7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//计算个人所得税,3500,5000,3500与5000税后金额差,输入税前工资 显示税后工资  显示交了多少税
		
//可扣除的成本=汇总成本金额/（1+6%）*0.06
//差额征税额=（不含税收入-可扣减成本）/（1+税率）*税率-可抵扣的进项税
		
		Scanner sc = new Scanner(System.in);
		double ys = 0;
		
		System.out.println("请输入税前金额:");
		double money = sc.nextDouble();
		System.out.println("请输入五险一金金额:");
		double w = sc.nextDouble();
		System.out.println("请输入起征点金额:");
		double q = sc.nextDouble();
		
		double y = money-w-q;
		System.out.println("应纳税所得金额：  "+ y);
				
//		速算扣除数 ：0
		
		if(y>0&&y<=1500){
			
			ys = y*0.03-0.00;
			System.out.println("应纳税金额:"+ ys);
		}
		else if(y>1500&&y<=4500){
			
			ys = y*0.1-0.00;
			System.out.println("应纳税金额:"+ ys);
		}
		else if(y>4500&&y<=9000){
			
			ys = y*0.20-0.00;
			System.out.println("应纳税金额:"+ ys);
		}
		else if(y>9000&&y<=35000){
			
			ys = y*0.25-0.00;
			System.out.println("应纳税金额:"+ ys);
		}
		else if(y>35000&&y<=55000){
			
			ys = y*0.30-0.00;
			System.out.println("应纳税金额:"+ ys);
		}
		else if(y>55000&&y<=8000000){
			
			ys = y*0.35-0.00;
			System.out.println("应纳税金额:"+ ys);
		}
		else if(y>8000000){
			ys = y*0.45-0.00;
			System.out.println("应纳税金额:"+ ys);
		}
		
		double s = money-w-ys;
		System.out.println("税后工资"+s);
	}

}
