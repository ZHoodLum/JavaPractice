package com.neusoft.test;

public class practice2 {
	public static void main(String args[]) {
		double f = 110;
		double c = 37;
		System.out.println("华氏度变成摄氏度:" + (f - 32.0)*5/9);
		System.out.println("摄氏度变成华氏度" + c*9.0/5+32);
		System.out.println("\n");
		System.out.println("华氏度变成摄氏度:" + String.format("%.2f", (f - 32.0)*5/9));//保留小数点后两位
		System.out.println("华氏度变成摄氏度:" + String.format("%.2f",  c*9.0/5+32));//保留小数点后两位
		
		
	}
}
