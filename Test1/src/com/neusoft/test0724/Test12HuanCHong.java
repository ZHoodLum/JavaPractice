package com.neusoft.test0724;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test12HuanCHong {
	public static void main(String[] args) throws Exception {
		/**
		 * ������   �������I/O�Ķ�д�ٶȡ�
		 *
		 * 1���ֽڻ�����  BufferedOutputStream  BufferedInputStream
		 * 2���ַ�������
		 * 
		 *  f����      java.io.OutputStream------�� java.io.FilterOutputStream---��BufferedOutputStream
		 * ԭ���൱���½���һ��byte���͵�����
		 * BufferedInputStream(OutputStream ops)
		 * ���԰��ֽ����������������ֽ����ڴ���ʱ���������Ч�ʡ�
		 * 
		 * 
		 */
		FileOutputStream fops1 = new FileOutputStream("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\aaa.txt");
		
		BufferedOutputStream bops1 = new BufferedOutputStream(fops1);
		byte[] barry = "��ð���".getBytes();
		String s1 = new String(barry,"GBk");
		System.out.println(s1);
		for(byte n:barry){
			System.out.println(n);
		}
		
		bops1.write(new byte[]{12,32,45});
		bops1.close();
		
		fops1.close();
		System.out.println("-. -");
	}
}
