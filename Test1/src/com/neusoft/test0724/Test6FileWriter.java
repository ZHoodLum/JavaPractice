package com.neusoft.test0724;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test6FileWriter {
	public static void main(String[] args) throws Exception {

		/**
		 * �ַ�������----���ַ�
		 * FileWriter
		 * 
		 */
		char[] carry1 = new char[]{'1','2','3','4'};
		File f1 = new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\aaa.txt");
		FileWriter fw1 = new FileWriter(f1,true);
		
		fw1.write(carry1);
		fw1.flush();
		fw1.close();//Ĭ�������� ��flush
		
		
		
		
		
		
		
		
		
	}
}
