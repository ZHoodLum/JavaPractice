package com.neusoft.test0723JiHe;

import java.util.ArrayList;
import java.util.Collection;

public class Test2 {
	public static void main(String[] args) {
		
		//�����п����Զ�����
		Collection c1 = new ArrayList();
		/**
		 * 
		 * Object��������ĳ���
		 * Ҳ�ǰ�װ�������͵ĳ���
		 * ��Ϊ �����������ͣ����ʣ��Զ�װ�䣺
		 * ����int ���͵�10   ת��Ϊinteger���͵�10   int 10  -----> integer  10
		 * ��Ϊ��װ�������͵ĳ��࣬����integer 10  �൱�ڱ�ΪObject���� �ĸ�������ָ��������������  ��ʽ
		 * ����10  ���Էŵ������Ĳ�������
		 */
		c1.add(10);
		c1.add(20);
		c1.add(30);
		c1.add(40);
		c1.add(50);
		c1.add(60);
		c1.add(70);
		c1.add(80);
		c1.add(90);
		
		c1.size();
		System.out.println(c1.size());
		System.out.println(c1.toArray());
		
		Object[] o1array = c1.toArray();
		/**
		 * ��������
		 * Ϊ������Ա���Object���͵����飿
		 * ��syso�������һ�����൱���Զ�����toString����
		 * ��Ϊ���ˣ���������ָ������������ʽ��Object o = new Integer(10);
		 * ����  ����toString�����Ƿ�����д��ʵ�ʵ��õ���Integer���е�toString����  ���������10
		 */
		for(Object o:o1array){
			System.out.println(o);
		}
		
	}
}
