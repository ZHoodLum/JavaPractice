package com.neusoft.test0724;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test5IO {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/**
		 * 将aaa内容拷贝到bb当中
		 */
		
		File f1 = new File("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.jpg");
		File f2 = new File("C:\\Users\\15532\\Desktop\\项目\\iotest\\bbb.jpg");
		
		//从aaa.txt当中取数据  从外存到内存------>input
		
		FileInputStream fis1 = new FileInputStream(f1);
		FileOutputStream fos1 = new FileOutputStream(f2,true);
		
		int n=0;
		
		while((n=fis1.read())!=-1){
			fos1.write(n);
		}
		
		fis1.close();
		fos1.close();
		
		System.out.println("运行ok!");
		
		
		
		
		
	}

}
