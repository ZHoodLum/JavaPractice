package com.neusoft.test0724;

import java.io.File;
import java.io.IOException;

public class Test3IO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * ��java�У�ʹ��"\"ʱ   ��Ҫ�õ�ת���ַ�"\",
		 * Ҫ���ӡ\  ��Ҫ���ӡ����һ�� "\\"
		 */
		String a = "E:\\eclipse";
		
//		System.out.println(File.pathSeparator);
		/**
		 * windows ��   \
		 * Linux Ч���� /
		 */
//		System.out.println(File.separator);
		
		File f1 = new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\aaa.txt");
		File f2 = new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest");
		File f3 = new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\bbb.txt");
		
		System.out.println(f1.exists());
		System.out.println(f2.exists());
		System.out.println(f3.exists());
		
		/**
		 * createNewFile �����ļ�
		 * �������ڶ�Ӧ�ļ�ʱ �����д���
		 * ������ĳ���ļ������������ļ������κβ���
		 */
		try {
			boolean iscreate1 = f3.createNewFile();
			System.out.println(iscreate1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File f4 = new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\a1\\b1");
		/**
		 * �����༶Ŀ¼ mkdirs
		 * ��������Ŀ¼mkdir
		 * 
		 */
		boolean iscreatepackage = f4.mkdirs();
		System.out.println(iscreatepackage);
		
		/**
		 * ɾ��·��
		 * ����������վ  ֱ��ɾ��
		 */
//		boolean isdelete = f4.delete();
//		System.out.println(isdelete);

		/**
		 * �޸��ļ���
		 * ���� ���޸��ļ����ƣ���������
		 */
		File f5 = new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\a1\\b1");
		File f6 = new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\a1\\b2");
		boolean isrename = f5.renameTo(f6);
		System.out.println(isrename);
		
		//getName() ���ļ����ڷ��Ƿ��޹أ�ʵ�������ڽ�ȡ�ַ���
		System.out.println(f1.getName());
		System.out.println(f2.getName());
		
		//jd-jui���Բ鿴.class ���������
		//�����ֽ��� byte
		/**
		 * isHidden ���Գ������ļ��Ƿ�Ϊ�����ļ�
		 * 
		 * Dateʱ���� ����ֱ�ӽ�����ת��Ϊ���ڸ�ʽ
		 * 
		 * f1.getAbsolutePath()  ��þ���·��
		 * 
		 * f1.getParentFile()  ��ø���·��
		 * f1.getParentFile().getParentFile()  ��ø���·��
		 */
		System.out.println(f1.length());
		
		System.out.println(f1.getAbsolutePath());
		
		System.out.println(f1.getParentFile());
		
		System.out.println("*******");
		/**
		 * ������ǰĿ¼
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
				//��Ŀ¼���ڽ��б���   ������·��
				File[] farray2 = file.listFiles();
				for(File file1:farray2){
					System.out.println(file1.getName());
				}
			}
		}
		
		
		
		
		
		
		
	}

}
