package com.neusoft.test0721;

public class test2 {
	public static void main(String[] args) {
		
	}
	//先算阶乘  再算 加减。
	//1-x 的阶乘相加
	public static int jiecheng(int num){
		if(num == 1){
			return 1;
		}
		return num * jiecheng(num - 1);
	}
	
	public static int jiechengAdd(int num){
		if(num == 1){
			return jiecheng(num);
		}
		return jiecheng(num) + jiechengAdd(num-1);
	}
	
	//
	public static int jiecheng(){
		return 0;
		
	}
	
	
}
