package com.neusoft.test0716;


//�鿴Person
public class Test6 {
	
	public static void main(String[] args) {
		//Person
		/**
		 * ������һ����������
		 * ��ʶ�������ģ�������new������
		 * ��Ҫnew����   �� ����  ������ = new ����������
		 */
		Person jl = new Person();
		jl.name="����";
		jl.duixiang = true;
		jl.say();
		
		System.out.println("------------------------");
		
		Person wx = new Person();
		wx.name="����";
		wx.say();
		
	}

}
