package com.neusoft.test0724;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Test1.Person;

public class Test13Object {
	public static void main(String[] args) throws IOException {
		/**
		 * ���л���  ObjectInoutStream    ObjectOutputStream
		 * ���л���Ϊ  ���л��ͷ����л�
		 * 
		 * ����ʵ�����л�  ����ʵ�����л��ӿ�
		 * ���л� �� ObjectOutputStream��  �ڴ浽���������л�  �ڶ��ڴ浱�д������� ���ŵ���棨Ӳ�̣�����  ��Ϊ���л�
		 * java.io.OutputStream -------->java.io.InputStream
		 * 
		 * ������뱻���л�������취�� transient���η�    static����
		 * 
		 * 
		 * �����л���ObjectInoutStream��   ��浽�ڴ�  ���������õ��ڴ浱��  ��Ϊ�����л�
		 * 
		 * 
		 * ʹ�÷�����writeObject(Object obj)
		 */
		Person jl = new Person();
		jl.setAge(18);
		jl.setName("����");
		
		FileOutputStream fops1 = new FileOutputStream("C:\\Users\\15532\\Desktop\\��Ŀ\\iotest\\aaa.txt");
		
		//�߼���
		ObjectOutputStream oop1 = new ObjectOutputStream(fops1);
		
		oop1.writeObject(jl);
		
		oop1.close();
		fops1.close();
		System.out.println("---");
		
		
	}
}
