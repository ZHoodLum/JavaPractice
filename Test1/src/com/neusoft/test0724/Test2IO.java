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
		 * ��  ��Ϊ�����������
		 * ������ ���ڴ�
		 * �������OutputStream
		 * �ڴ�----->���
		 * 
		 * ��������InputStream
		 * ���----->�ڴ�
		 * 
		 * �� �����Է�Ϊ���ֽ���   �ַ���
		 * �ֽ���byte:���Բ����κ����֡�ͼƬ����Ƶ�ȵ�  �ڼ����ϵͳ�У�
		 * �������ֽ����洢
		 * OutputStream    InputStream
		 * ���ַ��� ��ʹ�þ��о����ԣ�ֻ�ܲ����ַ�������
		 * 
		 * �����ַ��� Reader��Writer
		 */
		
		//OutputStream ��������ĸ���
		File f1 = new File("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\aaa.txt");
		OutputStream os1 = null;
		try {
			os1 = new FileOutputStream(f1);
			/**
			 * \r\n  ���з�
			 */
			String s1 = "dafaf gaga gaha ��\r\n";
			String s2 = "d666666666666666666666666666666666666";
//			os1.write('d');
//			os1.write(new byte[]{'1', '2', '5','6','8'});
			//ʹ��true  ��ʵ���ظ���д
			os1 = new FileOutputStream(f1,true);
//			os1.close();
			os1.write(s1.getBytes());
			os1.write(s2.getBytes());
			System.out.println("��д�ɹ���");
			
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
