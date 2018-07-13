package com.neusoft.test0713;

import java.util.Arrays;

public class trangle5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
//		在一个有8个整数（18，25，7，36，13，2，89，63）的数组中找出其中最大的数及其下标
=======
>>>>>>> 7cb5949dfe8e48280cd7b698ca9aaeb4839dbc0f
		int[] a = {18,25,7,36,13,2,89,63};
//		Arrays类中的sort()使用的是经过调优的快速排序法;
		Arrays.sort(a);
		int i=0;
		for(i=0;i<a.length;i++){
			if(i==(a.length-1)){
				System.out.println("数组下标为："+i);
			}
		}
		System.out.println(a[a.length-1]);
		
//		int i=0;
//		for(i=0;i<a.length-1;i++){
//			if(a[i]>a[i+1]){
//				int temp = a[i+1];
//				a[i+1]=a[i];
//				a[i]=temp;
//			}	
//		}
//		System.out.println(a[a.length-1]);
//		
//		if(i==(a.length-1)){
//			System.out.println("数组下标为："+i);
//		}
	}

}
