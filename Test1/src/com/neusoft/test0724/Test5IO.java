package com.neusoft.test0724;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test5IO {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/**
		 * ��aaa���ݿ�����bb����
		 */
		
		File f1 = new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\aaa.jpg");
		File f2 = new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\bbb.jpg");
		
		//��aaa.txt����ȡ����  ����浽�ڴ�------>input
		
		FileInputStream fis1 = new FileInputStream(f1);
		FileOutputStream fos1 = new FileOutputStream(f2,true);
		
		int n=0;
		
		while((n=fis1.read())!=-1){
			fos1.write(n);
		}
		
		fis1.close();
		fos1.close();
		
		System.out.println("����ok!");
		
		
		
		
		
	}

}
