package com.neusoft.test0713;

import java.util.Arrays;

public class trangle3 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
//		给定一个有9个整数（1,6,2,3,9,4,5,7,8）的数组，先排序，然后输出排序后的数组的值
		int[] a = {1,6,2,3,9,4,5,7,8};
		
		//冒泡排序
/*		for(int j=0;j<a.length;j++){
			
			for(int i=0;i<a.length-1-j;i++){
				if(a[i]>a[i+1]){
					int temp = a[i+1];
					a[i+1] = a[i];
					a[i] = temp;
				}
			}	
		}
		for(int n:a){
			System.out.print(n+" ");
		}
*/		
		//arrays.sort排序
		Arrays.sort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}

	}

}
