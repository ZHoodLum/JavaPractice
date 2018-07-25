package com.neusoft.test0724;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test12HuanCHong {
	public static void main(String[] args) throws Exception {
		/**
		 * 缓冲流   可以提高I/O的读写速度。
		 *
		 * 1、字节缓冲流  BufferedOutputStream  BufferedInputStream
		 * 2、字符缓冲流
		 * 
		 *  f父类      java.io.OutputStream------》 java.io.FilterOutputStream---》BufferedOutputStream
		 * 原理：相当于新建了一个byte类型的数组
		 * BufferedInputStream(OutputStream ops)
		 * 可以绑定字节输出流，被传入的字节流在传输时，可以提高效率。
		 * 
		 * 
		 */
		FileOutputStream fops1 = new FileOutputStream("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.txt");
		
		BufferedOutputStream bops1 = new BufferedOutputStream(fops1);
		byte[] barry = "你好啊！".getBytes();
		String s1 = new String(barry,"GBk");
		System.out.println(s1);
		for(byte n:barry){
			System.out.println(n);
		}
		
		bops1.write(new byte[]{12,32,45});
		bops1.close();
		
		fops1.close();
		System.out.println("-. -");
	}
}
