package com.neusoft.test0714;

public class test4 {
	
	/**
	 * �ݹ��㷨
	 * 1+2+������100
	 * ��ݹ� �ҹ��� �ҳ���
	 * �ҵ��Լ������Լ�����
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
