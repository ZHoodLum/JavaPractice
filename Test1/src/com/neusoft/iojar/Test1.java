package com.neusoft.iojar;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Test1 {
	public static void main(String[] args) throws Exception {
		//io工具包
		//copy文件
		FileUtils.copyFile(new File("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.jpg"), new File("C:\\Users\\15532\\Desktop\\项目\\iotest\\bbb.jpg"));
		//将字符串copy当中
		FileUtils.writeStringToFile(new File("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.txt"), "就是爽啊！",true);
		//读文本
		String s1 = FileUtils.readFileToString(new File("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.txt"));
		System.out.println(s1);
		
		System.out.println("--");
	}
}
