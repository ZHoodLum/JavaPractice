package com.neusoft.test0724;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test2IO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/**
		 * 流  分为输入与输出流
		 * 参照物 ：内存
		 * 输出流：OutputStream
		 * 内存----->外存
		 * 
		 * 输入流：InputStream
		 * 外存----->内存
		 * 
		 * 流 还可以分为：字节流   字符流
		 * 字节流byte:可以操作任何文字、图片、视频等等  在计算机系统中，
		 * 都是以字节流存储
		 * OutputStream    InputStream
		 * 而字符流 ：使用具有局限性，只能操作字符流数据
		 * 
		 * 常见字符流 Reader、Writer
		 */
		
		//OutputStream 是输出流的父类
		File f1 = new File("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.txt");
		OutputStream os1 = null;
		try {
			os1 = new FileOutputStream(f1);
			/**
			 * \r\n  换行符
			 */
			String s1 = "dafaf gaga gaha ？\r\n";
			String s2 = "d666666666666666666666666666666666666";
//			os1.write('d');
//			os1.write(new byte[]{'1', '2', '5','6','8'});
			//使用true  可实现重复书写
			os1 = new FileOutputStream(f1,true);
//			os1.close();
			os1.write(s1.getBytes());
			os1.write(s2.getBytes());
			System.out.println("书写成功！");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(os1!=null){
				os1.close();
			}
		}
		
		
		
		
	}

}
