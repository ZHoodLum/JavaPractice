package com.neusoft.test0713;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
<<<<<<< HEAD

=======
		for(;;){
>>>>>>> 7cb5949dfe8e48280cd7b698ca9aaeb4839dbc0f
			double a=0,b=0,c=0;
			double r=1;
			Scanner sa = new Scanner(System.in);
			
			System.out.println("请输入一个数：");
			a=sa.nextDouble(); 
			
			System.out.println("请输入一个运算符：");
			String s = sa.next();
			
			System.out.println("请输入一个数：");
			b=sa.nextDouble();
			
			for(int i=0;i<=s.length()-1;i++) {
				if(s.equals("+")) {
					System.out.println("运算+得："+(c=a+b));
				}else if(s.equals("-")){
					System.out.println("运算-得："+(c=a-b));
				}else if(s.equals("*")){
					System.out.println("运算*得："+(c=a*b));
				}else if(s.equals("/")){
					if(b==0){
						System.out.println("除数不能为0！");
//						System.exit(0);
					}else{
					System.out.println("运算/得："+(c=a/b));
					}
				}
<<<<<<< HEAD
				else if(s.equals("^")){
//					for(int j=0;j<(b-1);j++){
//						if(i==0){
//							c=a*a;
//						}else{
//							c=c*a;
//						}
//						System.out.println("运算得："+c);
//					}
					for(int j=0;j<b;j++) {
					 r = r *a;//当j等于1 进行r= r*a 由于j<b   所以再一次进行运算r*a(r为第一次运算的)
					}
					System.out.println("运算得："+r);
				}
				
=======
				else {
					for(int j=0;j<b;j++) {
					 r = r *a;//当j等于1 进行r= r*a 由于j<b   所以再一次进行运算r*a(r为第一次运算的)
					 System.out.println("运算得："+r);
					}
				}
				System.out.println();
>>>>>>> 7cb5949dfe8e48280cd7b698ca9aaeb4839dbc0f
			}
		}
	}

<<<<<<< HEAD
=======
}
>>>>>>> 7cb5949dfe8e48280cd7b698ca9aaeb4839dbc0f
