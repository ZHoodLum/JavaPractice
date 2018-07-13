package com.neusoft.test0713;

import java.util.Scanner;

public class Htest7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//计算个人所得税,3500,5000,3500与5000税后金额差,输入税前工资 显示税后工资  显示交了多少税
		
//可扣除的成本=汇总成本金额/（1+6%）*0.06
//差额征税额=（不含税收入-可扣减成本）/（1+税率）*税率-可抵扣的进项税
		
		Scanner s = new Scanner(System.in);
		double money = s.nextDouble();
		
		double l=money/(1+0.06)*0.06;
		System.out.println("可扣减成本：  "+l);
		double num = (money-l)/(1+0.06)*0.06;
		System.out.println("差额征税额： "+num);
		
	}

}
