package com.neusoft.test0724;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test12BufferedWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * �ַ���  ������
		 * BufferWriter
		 * 
		 */
		//������
		FileWriter fw1 = new FileWriter("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\aaa.txt");
		//�߼���
		BufferedWriter bw1 = new BufferedWriter(fw1);
		bw1.write("Ű��ǧ�ٱ飡".toCharArray());
		
		bw1.flush();
		bw1.write("�����������");
		bw1.close();
		System.out.println("-,-");
	}

}
