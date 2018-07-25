package com.neusoft.test0724;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class Test8 {
	public static void main(String[] args) throws Exception {
		//将aaa.txt 复制到 bbb.txt中
		/**
		 * 字节流  建立缓冲区 ----》byte数组
		 * 字符流  建立缓冲区-----》char数组
		 */
		FileReader fr1 = new FileReader("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.txt");
		FileWriter fw1 = new FileWriter("C:\\Users\\15532\\Desktop\\项目\\iotest\\bbb.txt");
		
		int n =0;
		char[] c1 = new char[1024];
		while((fr1.read(c1)!=-1)){
			fw1.write(c1,0,n);
			fw1.flush();
		}
		fw1.close();
		fr1.close();
		System.out.println("---");
	}
}
