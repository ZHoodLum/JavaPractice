package com.neusoft.test0718;

public class BB {
	
	/**
	 * ����ģʽ
	 * �������ⲿnew���
	 * 
	 * //����ʽ����ģʽ
	 * һ����getInstance����ʱ  ��ʵ��������
	 */
	
	
	private BB(){
		
	}
	//��Ա����  ��Ϊ��private �ⲿ������new���  ֻ���Լ�new 
	private static BB bb = null;
	
	public static BB getInstance(){
		if(bb == null){
			bb = new BB();
		}
		return bb;
		
	}
	
	
	
	
	
	
}
