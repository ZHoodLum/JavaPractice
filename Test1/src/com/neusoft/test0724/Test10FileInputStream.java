package com.neusoft.test0724;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Test10FileInputStream {
	public static void main(String[] args) throws Exception {
		
		/**
		 * FileInputStream
		 * InputStreaWriter �����ֽ���ͨ���ַ���������  �ַ���
		 */
		
		//�ڵ���
		FileInputStream fis = new FileInputStream("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\aaa.txt");//
		//����������
		//Ĭ���ַ��� GBK   UTF-8 д��ʱ��Ҫ��ͳһ�ַ���
		// ��   ȡ     ��   ��  �����ʽҪ��һ��
		InputStreamReader isr = new InputStreamReader(fis,"GBK");
		
//		new FileWriter("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\aaa.txt");
		int n = 0;
		char[] c1 = new char[5];
		while((n = isr.read(c1))!=-1){
			isr.read(c1,0,n);
			String s1 = new String(c1);
			System.out.println(s1);
		}
		
	}
}
