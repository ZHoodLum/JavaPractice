package com.neusoft.test0724;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test4IO {
	public static void main(String[] args) throws Exception {
		
		
		//������ InputStream
		//���-----���ڴ�
		
		File f1 = new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\aaa.txt");
		
		FileInputStream fis = new FileInputStream(f1);
		
		/*int i1 = fis.read();
		System.out.println((char)i1);
		
		int i2 = fis.read();
		System.out.println((char)i2);
		int i3 = fis.read();
		System.out.println((char)i3);*/
		
		/**
		 * ����������  ������Ϊ-1
		 */
		/*int i4 = fis.read();
		System.out.println(i4);*/
		
		
		/**
		 * fis.rea() ��ֵ����n
		 * n ��-1 ���Ƚ�
		 */
		int n = 0;
		while((n = fis.read())!=-1){
			System.out.println((char)n);
		}
		fis.close();
		
	}
}
