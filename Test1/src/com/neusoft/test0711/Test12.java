package com.neusoft.test0711;

import java.util.Scanner;

public class Test12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		if(a%400==0){
			System.out.println("���������갡��");
		}else if(a%100==0&&a%400!=0){
			System.out.println("���겻�����갡��");
		}else if(a%4==0&&a%400!=0){
			System.out.println("���������갡��");
		}else{
			System.out.println("��������Ŷ����");
		}
	}

}
