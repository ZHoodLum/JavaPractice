package com.neusoft.test0714;

public class test1 {
	public static void main(String[] args) {
		aaa();
		aaa(6);
		aaa('��');
	}
	
	//����������ͬ ���������Ͳ�ͬ ������������������������
	/**
	 * ���������ؾ�����ͬһ����������ͬʱ����һ������ͬ���ķ���
	 * ���������� ֻ�����������йأ� ������������������
	 */
	

	
//	��������ͬ     1��2����������ͬ
//	��������ͬ     2��3����������ͬ���������Ͳ�ͬ
	
	//1
	public static void aaa(){
		System.out.println("û�в�����aaa");
	}
	//2
	public static void aaa(int a){
		System.out.println("�в�����aaa");
	}
	//3
	public static void aaa(char a){
		System.out.println("��һ��char������aaa");
	}
	
//	4  5������ ��Ϊ˳��ͬ           ��Ϊ�������Ͳ�ͬ
	
	//4
	public static void aaa(int b,char a){
		System.out.println("��һ��char������aaa");
	}//5
	public static void aaa(char a,int b){
		System.out.println("��һ��char������aaa");
	}
	
	/**
	 * 6 7��������
	 */
	
	//6
	/*public static void bbb(int b,char a){
		System.out.println("��һ��char������bbb");
	}//7
	public static void bbb(int a,char b){
		System.out.println("��һ��char������bbb");
	}*/
	
	
	/*
	 * �������� ����������ֵ�����޹�
	 */
	//8
	public static void ccc(int b,char a){
		System.out.println(a+b);
		System.out.println("��һ��char������aaa");
	}//9
/*	public static int ccc(int b,char a){
		System.out.println("��һ��char������aaa");
		return a+b;
	}*/
	
	public static void hit(int gongjili,int juli){
		
	}
	public static void hit(int gongji){
		
	}
	
}	
