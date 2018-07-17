package com.neusoft.test0716;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i=0;i<2;i++){
//			for(int j=0;j<i-1;j++){
//				System.out.println("*");
//			}
//		}
		
		int[] a = {2,5,4,8,7};
		
		for(int j=0;j<a.length;j++){
			for(int i=0;i<a.length-1-j;i++){
				if(a[i]>a[i+1]){
					int temp = 0;
					//a[i]  a[i+1] ½øÐÐÎ»ÖÃ»¥»»
					temp =a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
				}
			}	
		}
		for(int n:a){
			System.out.println(n);
		}
			
		}
	}

