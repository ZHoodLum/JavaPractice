package com.neusoft.test0712;

import java.util.Scanner;

public class Htest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   System.out.println("������һ��������ݣ�");		
       for(;;){
			Scanner s = new Scanner(System.in);
			int a = s.nextInt();
			if(a%400==0){
				System.out.println("���������갡��");continue;
			}else if(a%4==0&&a%100!=0){
				System.out.println("���������갡��");continue;
			}else{
				System.out.println("��������Ŷ����");continue;
			}
		}
				
	}

}
