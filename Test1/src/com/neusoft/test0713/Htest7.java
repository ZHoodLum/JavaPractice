package com.neusoft.test0713;

import java.util.Scanner;

public class Htest7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//�����������˰,3500,5000,3500��5000˰�����,����˰ǰ���� ��ʾ˰����  ��ʾ���˶���˰
		
//�ɿ۳��ĳɱ�=���ܳɱ����/��1+6%��*0.06
//�����˰��=������˰����-�ɿۼ��ɱ���/��1+˰�ʣ�*˰��-�ɵֿ۵Ľ���˰
		
		Scanner sc = new Scanner(System.in);
		double ys = 0;
		
		System.out.println("������˰ǰ���:");
		double money = sc.nextDouble();
		System.out.println("����������һ����:");
		double w = sc.nextDouble();
		System.out.println("��������������:");
		double q = sc.nextDouble();
		
		double y = money-w-q;
		System.out.println("Ӧ��˰���ý�  "+ y);
				
//		����۳��� ��0
		
		if(y>0&&y<=1500){
			
			ys = y*0.03-0.00;
			System.out.println("Ӧ��˰���:"+ ys);
		}
		else if(y>1500&&y<=4500){
			
			ys = y*0.1-0.00;
			System.out.println("Ӧ��˰���:"+ ys);
		}
		else if(y>4500&&y<=9000){
			
			ys = y*0.20-0.00;
			System.out.println("Ӧ��˰���:"+ ys);
		}
		else if(y>9000&&y<=35000){
			
			ys = y*0.25-0.00;
			System.out.println("Ӧ��˰���:"+ ys);
		}
		else if(y>35000&&y<=55000){
			
			ys = y*0.30-0.00;
			System.out.println("Ӧ��˰���:"+ ys);
		}
		else if(y>55000&&y<=8000000){
			
			ys = y*0.35-0.00;
			System.out.println("Ӧ��˰���:"+ ys);
		}
		else if(y>8000000){
			ys = y*0.45-0.00;
			System.out.println("Ӧ��˰���:"+ ys);
		}
		
		double s = money-w-ys;
		System.out.println("˰����"+s);
	}

}
