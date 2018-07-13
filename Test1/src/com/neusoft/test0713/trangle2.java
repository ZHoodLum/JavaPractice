package com.neusoft.test0713;

public class trangle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		将一个字符数组的值（neusofteducation）拷贝到另一个字符数组中
		String[] a = {"neusofuducation"};
		
		String[] b = new String[1];
		
		System.arraycopy(a, 0, b, 0, a.length);
		
		for(String n:b){
			System.out.print(n);
		}
		
	}

}
