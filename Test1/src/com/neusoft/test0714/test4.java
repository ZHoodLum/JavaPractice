package com.neusoft.test0714;

public class test4 {
	
	/**
	 * 递归算法
	 * 1+2+。。。100
	 * 解递归 找规律 找出口
	 * 找到自己调用自己部分
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	public static int add2(int n){
		if(n==1){
			return 1;
		}else{
			return add2(n-1)+n;
		}
		
	}
	
}
