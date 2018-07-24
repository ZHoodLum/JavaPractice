package com.neusoft.test0724;

import java.io.File;
import java.io.IOException;

public class Test3IO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 再java中，使用"\"时   需要用到转义字符"\",
		 * 要想打印\  需要多打印出来一个 "\\"
		 */
		String a = "E:\\eclipse";
		
//		System.out.println(File.pathSeparator);
		/**
		 * windows 下   \
		 * Linux 效果是 /
		 */
//		System.out.println(File.separator);
		
		File f1 = new File("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.txt");
		File f2 = new File("C:\\Users\\15532\\Desktop\\项目\\iotest");
		File f3 = new File("C:\\Users\\15532\\Desktop\\项目\\iotest\\bbb.txt");
		
		System.out.println(f1.exists());
		System.out.println(f2.exists());
		System.out.println(f3.exists());
		
		/**
		 * createNewFile 创建文件
		 * 当不存在对应文件时 ，进行创建
		 * 而存在某个文件，不会对这个文件进行任何操作
		 */
		try {
			boolean iscreate1 = f3.createNewFile();
			System.out.println(iscreate1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File f4 = new File("C:\\Users\\15532\\Desktop\\项目\\iotest\\a1\\b1");
		/**
		 * 创建多级目录 mkdirs
		 * 创建单级目录mkdir
		 * 
		 */
		boolean iscreatepackage = f4.mkdirs();
		System.out.println(iscreatepackage);
		
		/**
		 * 删除路径
		 * 不会进入回收站  直接删除
		 */
//		boolean isdelete = f4.delete();
//		System.out.println(isdelete);

		/**
		 * 修改文件名
		 * 剪切 、修改文件名称（重命名）
		 */
		File f5 = new File("C:\\Users\\15532\\Desktop\\项目\\iotest\\a1\\b1");
		File f6 = new File("C:\\Users\\15532\\Desktop\\项目\\iotest\\a1\\b2");
		boolean isrename = f5.renameTo(f6);
		System.out.println(isrename);
		
		//getName() 与文件存在发是否无关，实际上是在截取字符串
		System.out.println(f1.getName());
		System.out.println(f2.getName());
		
		//jd-jui可以查看.class 反编译软件
		//返回字节数 byte
		/**
		 * isHidden 测试抽象类文件是否为隐藏文件
		 * 
		 * Date时间类 可以直接将毫秒转换为日期格式
		 * 
		 * f1.getAbsolutePath()  获得绝对路径
		 * 
		 * f1.getParentFile()  获得父类路径
		 * f1.getParentFile().getParentFile()  获得父类路径
		 */
		System.out.println(f1.length());
		
		System.out.println(f1.getAbsolutePath());
		
		System.out.println(f1.getParentFile());
		
		System.out.println("*******");
		/**
		 * 遍历当前目录
		 */
		String[] sarray1 = f2.list();
		for(String name:sarray1){
			System.out.println(name);
		}
		System.out.println("*******");
		
		File[] farray1 = f2.listFiles();
		for(File file:farray1){
			System.out.println(file.getName());
			System.out.println("*******");
			if(file.isDirectory()){
				//再目录中在进行遍历   遍历子路径
				File[] farray2 = file.listFiles();
				for(File file1:farray2){
					System.out.println(file1.getName());
				}
			}
		}
		
		
		
		
		
		
		
	}

}
