package com.neusoft.test0724;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Test9FileOutputStream {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		/**
		 * �ڵ�������һ���ض�������Դ(�ڵ�)��д���ݣ��磺�ļ����ڴ棩����
		 * ���������߼���/��������������Ҫ�нڵ�������������
		 * 
		 * InputStreamReader,OutputStreamwriter  ת����
		 * 
		 * OutputStreamwriter:�ַ���ͨ���ֽ���������������ָ��charset�ַ���
		 */
		
		//�ڵ���
		FileOutputStream fops = new FileOutputStream("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\aaa.txt",true);
		//����������
		//Ĭ���ַ��� GBK   UTF-8 д��ʱ��Ҫ��ͳһ�ַ���
		//editplus 
		OutputStreamWriter opstw = new OutputStreamWriter(fops,"GBK");
		
		opstw.write("��ã�          ");
		opstw.flush();
		opstw.close();
		fops.close();
		
		
		
	}

}
