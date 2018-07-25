package com.neusoft.test0724;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test12BufferedReader {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		/**
		 * ¶Á×Ö·û
		 */
		FileReader f1 = new FileReader("C:\\Users\\15532\\Desktop\\ÏîÄ¿\\iotest\\aaa.txt");
		BufferedReader br1 = new BufferedReader(f1);	
//		char[] c1 = new char[12];
//		while(f1.read(c1)!=-1);{
//			String s1 = new String(c1);
//			System.out.println(s1);
//		}
		/*int n = 0;
		char[] c1 = new char[10];
		while((n=br1.read(c1))!=-1);{
			br1.read(c1,0,n);		
		}
		String s1 = new String(c1);
		System.out.println(s1);
		br1.close();
		f1.close();*/
		
		String n = null;
		char[] c1 = new char[10];
		while((n=br1.readLine())!=null);{
//			System.out.println(br1.lines());		
		}
		
	}

}
