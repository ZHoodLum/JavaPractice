package com.neusoft.test0713;

import java.util.Arrays;

public class trangle3 {

	public static void main(String[] args) {
<<<<<<< HEAD
		
		// TODO Auto-generated method stub
//		����һ����9��������1,6,2,3,9,4,5,7,8�������飬������Ȼ����������������ֵ
=======
		// TODO Auto-generated method stub
>>>>>>> 7cb5949dfe8e48280cd7b698ca9aaeb4839dbc0f
		int[] a = {1,6,2,3,9,4,5,7,8};
		
		//ð������
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
		//arrays.sort����
		Arrays.sort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}

	}

}
