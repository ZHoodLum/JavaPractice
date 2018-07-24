package com.neusoft.test0724;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test4IO {
	public static void main(String[] args) throws Exception {
		
		
		//输入流 InputStream
		//外存-----》内存
		
		File f1 = new File("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.txt");
		
		FileInputStream fis = new FileInputStream(f1);
		
		/*int i1 = fis.read();
		System.out.println((char)i1);
		
		int i2 = fis.read();
		System.out.println((char)i2);
		int i3 = fis.read();
		System.out.println((char)i3);*/
		
		/**
		 * 如果读到最后  输出结果为-1
		 */
		/*int i4 = fis.read();
		System.out.println(i4);*/
		
		
		/**
		 * fis.rea() 赋值给了n
		 * n 根-1 作比较
		 */
		int n = 0;
		while((n = fis.read())!=-1){
			System.out.println((char)n);
		}
		fis.close();
		
	}
}
