package com.neusoft.test0714;

import java.util.Random;

public class Htest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//篮球1-16
		int blueball = suiji(1,16);
		//红球 6个  不可重复  范围 1-33
		int[] a = new int[6];
		shuzu(a);
		
		//输出中奖号码
		System.out.println("篮球为："+blueball);
		System.out.print("红球为：");
		bianliArray(a);
		
		
	}
	public static int suiji(int n,int m){
		Random r = new Random();
		
//		1-10之间的数
//		int k = r.nextInt(10)+1;
//		5-8之间的数
//		int k1 = r.nextInt(8-5+1)+5;
//		n-m之间的数
		int k2 = r.nextInt(m-n+1)+n;
		return k2;
		
	}
	/*
	 * 创建数组
	 * 红球范围 1-33
	 * 要求：向数组中装入6个随机数  范围是1-33，并且不重复
	 * 
	 */
	
	public static void shuzu(int[] a){	
		Random r = new Random();
		int[] redballArray = new int[6];
//		for(int i=0;i<6;i++){
//			
//		}
		
	}
	//公共方法 用于遍历数组
	public static void bianliArray(int[] a){
		System.out.println("数组为：");
		for(int n:a){
			System.out.print(n+" ");
		}
		System.out.println();
	}
		
}
