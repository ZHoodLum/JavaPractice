package com.neusoft.test0720;

public class Test7 {

	
	public static void main(String[] args) {
		//从大到小
		int[] a = {34,45,67,49,97,43,89,3,113};
		
		for(int j=0;j<a.length;j++){
			for(int i=0;i<a.length-j-1;i++){
				if(a[i]>a[i+1]){
					int temp = a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
				}
			}
		}
		for(int n:a){
			System.out.println(n);
		}
		
		//

		for(int j=0;j<a.length;j++){
			for(int i=0;i<a.length-j-1;i++){
				int temp=a[i];
				a[i] = Math.max(a[i], a[i+1]);
				a[i+1] = Math.min(temp, a[i+1]);
				
			}
		}
		for(int n:a){
			System.out.println(n);
		}
		
		
		
		
	}
}
