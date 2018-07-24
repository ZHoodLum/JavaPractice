package com.neusoft.test0724;

import java.util.Scanner;

public class Testring {

	int a=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//3.写一个方法，使用linkedlist  栈实现  队列 功能
		    //4.写一个方法，使用数组实现环形队列 覆盖功能 最大存储10个整数
		    //5.将元素 23，7，56，7，4，32，36，78，5，98 放到集合当中按从小到大输出
//		               （集合类自选，输出时使用迭代器遍历输出）
//		Random r=new Random();
//		int y=r.nextInt(6)+1;
//		int x=r.nextInt(8)+1;
//		System.out.println("y="+y+";x="+x);
		Testring t=new Testring();
	   int[] a=new int[10];
		int[] b= t.shuru();
		for(int n:b){
			System.out.println(n);
		}
		t.ring(a,b);
		for(int n:a){
			System.out.print(n+",");
		}
	}
	
	
	public  int[] shuru(){//输入 数       //返回输入数据的   int数组
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数字用,分割");
		String s=sc.next();
		String[] sarry=s.split(",");//11，23，23，34，54----》{"11","23","23","34","54"}
		
		int[]   sintarray=new int[sarry.length]; //{0,0,0,0,0,0,0,0,0,0,0}
		
		for(int i=0;i<sarry.length;i++){   ////{"11","23","23","34","54"}
			
			sintarray[i]=Integer.parseInt(sarry[i]);
			
		}
		
		return sintarray;
	}
	
	public  void ring(int[] a,int[] b){// a[]画圆环    最多装10个    ,   b[]装着我们的模拟输入的数据
		
		for(int i=0;i<b.length;i++){
			this.a=i%10;
			a[this.a]=b[i];
			
		}
		
		
	}
}
