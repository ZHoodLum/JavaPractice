package com.neusoft.test0718;

public class AATest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		AA a1 = new AA();
//		AA a2 = new AA();		

		AA a1 = AA.getInstance();
		AA a2 = AA.getInstance();
		
		System.out.println(a1);
		System.out.println(a2);
		
		System.out.println(a1==a2);//≈–∂œœ‡µ»
	}

}
