package com.neusoft.test0713;

public class Htest9 {
	public static void main(String[] args) {
//		int[] a = {5,2,3,6};
//		for(int j=0;j<a.length;j++){
//				for(int i=0;i<a.length-1-j;i++){
//					
//					if(a[i]>a[i+1]){
//						int temp = 0;
//						temp =a[i+1];
//						a[i+1]=a[i];
//						a[i]=temp;
//					}
//				}	
//		}
//		for(int n:a){
//			System.out.print(n);
//		}
		
		
		  int[] a = {0,2,25,6,4,8,9};
		  for(int i =0;i<a.length;i++){//循环数组组数
			  for(int j=0;j<a.length-1-j;j++){//对数组内部进行循环判断 大小
				  
				  if(a[i]>a[i+1]){//进行判断
					int temp = 0;
					temp =a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
				  }
			  }
		  }
		 
	}
}
