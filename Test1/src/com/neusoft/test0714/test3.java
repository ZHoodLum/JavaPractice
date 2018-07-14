package com.neusoft.test0714;

public class test3 {

	public static void main(String[] args) {
		int sum = add(3);
		System.out.println(sum);
		
	}

	public static void aaa(){
		System.out.println("aaa");
		aaa();
	}
	public static int add(int i){
//		/程序出口  返回一个不再调用自己方法的值
		if(i==1){ 
//			System.out.println("+1+1");
			return i;
		}else{
			if(i==100){
//				System.out.println(i);
			}
			return i+add(i-1);
		}
	}
}	
