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
		 * InputStreaWriter ：是字节流通向字符流的桥梁  字符集
		 */
		
		//节点流
		FileInputStream fis = new FileInputStream("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.txt");//
		//构建处理流
		//默认字符集 GBK   UTF-8 写的时候要求统一字符集
		// 读   取     字   符  编码格式要求一致
		InputStreamReader isr = new InputStreamReader(fis,"GBK");
		
//		new FileWriter("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.txt");
		int n = 0;
		char[] c1 = new char[5];
		while((n = isr.read(c1))!=-1){
			isr.read(c1,0,n);
			String s1 = new String(c1);
			System.out.println(s1);
		}
		
	}
}
