package com.neusoft.test0713;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(;;){
			double a=0,b=0,c=0;
			double r=1;
			Scanner sa = new Scanner(System.in);
			
			System.out.println("������һ������");
			a=sa.nextDouble(); 
			
			System.out.println("������һ���������");
			String s = sa.next();
			
			System.out.println("������һ������");
			b=sa.nextDouble();
			
			for(int i=0;i<=s.length()-1;i++) {
				if(s.equals("+")) {
					System.out.println("����+�ã�"+(c=a+b));
				}else if(s.equals("-")){
					System.out.println("����-�ã�"+(c=a-b));
				}else if(s.equals("*")){
					System.out.println("����*�ã�"+(c=a*b));
				}else if(s.equals("/")){
					if(b==0){
						System.out.println("��������Ϊ0��");
//						System.exit(0);
					}else{
					System.out.println("����/�ã�"+(c=a/b));
					}
				}
				else {
					for(int j=0;j<b;j++) {
					 r = r *a;//��j����1 ����r= r*a ����j<b   ������һ�ν�������r*a(rΪ��һ�������)
					 System.out.println("����ã�"+r);
					}
				}
				System.out.println();
			}
		}
	}

}
