package com.neusoft.test0719;

import java.io.IOException;

public class Test1 {
	
	
	public static void main(String[] args) {
		//�쳣������ʱ  ���ֵĴ��󣬶����Ǳ���ʱ���ֵĴ���
		/**
		 * ����Ҫ���쳣������
		 * eg:�����±�Խ�硣��������
		 * 
		 * ��Ҫ���쳣������ ����쳣����
		 * Exception in thread "main" java.lang.StackOverflowError
		 * 
		 * 
		 */
	
//		method1();
		
		int[] b;
		try {
			b = new int[5];
			//�����±�Խ��
			System.out.println(b[6]);
		} 
		catch (NullPointerException e) {
//			e.printStackTrace();
			System.err.println("��ָ���쳣");
		}
		//���в����쳣 ������  ������������
		catch (ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
			System.err.println("�����±�Խ���쳣");
		}
		catch(Exception e){
			System.out.println("�����쳣��");
		}
		finally{
			System.out.println("����try�Ƿ����쳣������catch���쳣��񣬶����ִ��finally������");
		}
		System.out.println("----");
		
		
		
	}
	
	static void  method1(){
		method1();
	}
    void  method2() throws IOException{
    	
    	//���ּ�����쳣 �����������ʽ��1��try catch  2������throws�쳣
		System.out.println("IOException");
	}
	void  method3(){
		try {
			method2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void method4() throws IOException{
		method2();
	}
/**
 * 
 * throw�׳��쳣
 * 
 * throws�����쳣  �п��ܳ���������쳣����
 */
	//�η��������쳣 ����Ҫ������  ˭������ ˭��Ҫ����쳣
	void method5()throws IOException{
		throw new ArrayIndexOutOfBoundsException();//���ڷǼ�����쳣  
//		throw new IOException;  //���ڼ�����쳣   
	}
	
}
