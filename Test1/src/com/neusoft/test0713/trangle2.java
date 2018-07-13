package com.neusoft.test0713;

public class trangle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"neusofuducation"};
		
		String[] b = new String[1];
		
		System.arraycopy(a, 0, b, 0, a.length);
		
		for(String n:b){
			System.out.print(n);
		}
		
	}

}
