package com.neusoft.iojar;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Test1 {
	public static void main(String[] args) throws Exception {
		//io���߰�
		//copy�ļ�
		FileUtils.copyFile(new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\aaa.jpg"), new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\bbb.jpg"));
		//���ַ���copy����
		FileUtils.writeStringToFile(new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\aaa.txt"), "����ˬ����",true);
		//���ı�
		String s1 = FileUtils.readFileToString(new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\aaa.txt"));
		System.out.println(s1);
		
		System.out.println("--");
	}
}
