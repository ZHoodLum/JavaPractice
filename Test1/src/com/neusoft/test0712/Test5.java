package com.neusoft.test0712;

public class Test5 {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
//		do{
//			先进行一次 在进行判断
//		}while()
		
		int a = 1;
//		do{
//			System.out.println(a);
//
//		}while(a<100);
		
//		while(a<100){
//			System.out.println(a);
//			a++;
//		}
		
//		1-100 do  while
		int s = 0;
		do{
			s = s+a;
			a++;
		}while(a<=100);
		System.out.println(s);
		
//		使用while循环
		int i=1;
		int sum=0;
		while(i<=100){ //判断条件是否循环
			sum=sum+i;
			i++;//执行条件
		}
		System.out.println(sum);
		
//		for(初始化条件；判断条件；){}
		int p=0;
//		for(int t=1;t<=100;t++){
//			p=p+t;//核心逻辑
//		}
		for(int t=1;t<=99;t=t+2,t++){
			p=p+t;//核心逻辑
			
		}
		System.out.println(p);
		
		
		
	}
}
