package com.neusoft.test0724;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test12BufferInputStream {
	public static void main(String[] args) throws Exception {
		
		/**
		 * 使用BufferedInputStream 实现读取aaa.txt
		 */
		FileInputStream fis1 = new FileInputStream("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.txt");
		
		BufferedInputStream bis1 = new BufferedInputStream(fis1);
		int n = 0;
		byte[] b1 = new byte[10];
		while((n=bis1.read(b1))!=-1){
			System.out.println(new String(b1,"GBK"));
		}
		fis1.close();
		bis1.close();
	}
}
