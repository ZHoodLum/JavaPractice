package com.neusoft.test0724;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test12BufferedWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * 字符流  缓冲流
		 * BufferWriter
		 * 
		 */
		//基础流
		FileWriter fw1 = new FileWriter("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.txt");
		//高级流
		BufferedWriter bw1 = new BufferedWriter(fw1);
		bw1.write("虐我千百遍！".toCharArray());
		
		bw1.flush();
		bw1.write("带你如初恋！");
		bw1.close();
		System.out.println("-,-");
	}

}
