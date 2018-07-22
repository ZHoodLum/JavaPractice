package com.neusoft.test0721;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(aaa(20));
	}
	
	public static int aaa(int a ){
		if(a==1||a==2){
			
			return 1;
			
		}else{
			return aaa(a-1)+aaa(a-2);
		}
	}

}
