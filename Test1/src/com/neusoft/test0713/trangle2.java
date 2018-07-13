package com.neusoft.test0713;

public class trangle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
//		将一个字符数组的值（neusofteducation）拷贝到另一个字符数组中
=======
>>>>>>> 7cb5949dfe8e48280cd7b698ca9aaeb4839dbc0f
		String[] a = {"neusofuducation"};
		
		String[] b = new String[1];
		
		System.arraycopy(a, 0, b, 0, a.length);
		
		for(String n:b){
			System.out.print(n);
		}
		
	}

}
