package com.neusoft.test0718;

public class AA {
	
	

	/**
	 * ����ʽ����ģʽ
	 * ����һ���ص���̬������  ��ʵ��������
	 */
	private static AA instance = new AA();
	
	private AA(){
		
	}
	public static AA getInstance(){
		return instance;
	}
	
}
