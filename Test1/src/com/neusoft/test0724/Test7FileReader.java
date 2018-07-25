package com.neusoft.test0724;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test7FileReader {
	public static void main(String[] args) throws Exception {
		
		char[] c1 = new char[1024];
		/**
		 * ¶Á×Ö·û
		 */
		FileReader f1 = new FileReader("C:\\Users\\15532\\Desktop\\ÏîÄ¿\\iotest\\aaa.txt");
		while(f1.read(c1)!=-1);{
			String s1 = new String(c1);
			System.out.println(s1);
		}
		
		
	}
}
