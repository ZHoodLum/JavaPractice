package com.neusoft.test0724;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Test9FileOutputStream {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		/**
		 * 节点流：从一个特定的数据源(节点)读写数据（如：文件、内存）的类
		 * 处理流（高级流/特殊流），必须要有节点流（基础流）
		 * 
		 * InputStreamReader,OutputStreamwriter  转换流
		 * 
		 * OutputStreamwriter:字符流通向字节流的桥梁，可以指定charset字符集
		 */
		
		//节点流
		FileOutputStream fops = new FileOutputStream("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.txt",true);
		//构建处理流
		//默认字符集 GBK   UTF-8 写的时候要求统一字符集
		//editplus 
		OutputStreamWriter opstw = new OutputStreamWriter(fops,"GBK");
		
		opstw.write("你好！          ");
		opstw.flush();
		opstw.close();
		fops.close();
		
		
		
	}

}
