package com.neusoft.test0723JiHe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test3 {
	public static void main(String[] args) {
		/**
		 * ����Ҫ��ͳһ����������
		 * List�ӿ�<>���ͣ� ��ȡ˳��һ�£�------�����򣬿��ظ�
		 * 
		 * ��ʼֵ10   ÿ������1.5��   ���ҿ� ��ɾ��  ����ṹ
		 */
		List list = new ArrayList();
		//����һ��int���͵�����
//		int[] a = new int[10];
		Integer[] a = new Integer[10];
		String[] b = new String[10];
		
		a[0] = 1;
		System.out.println(a[0]);
		b[0] = "aaaa";
		System.out.println(b[0]);
		
		//int ---->String
		b[0] = 1 + "";
		
		//Object��������ĸ���
		//��Ȼ ������������û������  ��Ҫװ��ͬ�������͵����ݣ���ʱ���Ҫ�õ�����
		Object[] c = new Object[10];
		c[0] = 111;
		c[1] = "aaa";
		System.out.println(c[0]+" "+c[1]);
		/*
		* ʹ�÷��� <>   ���涨����������
		* ʹ�ü��� Ӧѧ�����ȥ��������
		 */
		List<String> list1 = new ArrayList<>();
		list1.add("������");
		list1.add("������");
		list1.add("������");
		list1.add("�����");
		list1.add("�����");
		list1.add("��˼��");
		//ɾ������  ����λ��
		list1.remove(1);
		//���������±�����޸�
		list1.set(1, "����������ԣ�");
		//��ѯ��һ�γ���ָ��Ԫ�ص�����  �����������Ԫ��  �򷵻�-1
		System.out.println(list1.indexOf("HHH"));
//		System.out.println(list1);
		
		System.out.println("------------------------");
		//��������б���
		//1��List(arrayList)  �Ѽ���ת��Ϊ���� �ٱ�������

		Object[] o = list1.toArray();
		for(Object n:o){
			System.out.println(n);
		}
		System.out.println("------------------------");
		//2��������  iterator ʹ�÷���  ��֤����ΪString��������
		ListIterator<String> i1 = list.listIterator();
//		Iterator<String> i1 = list1.iterator();
		while(i1.hasNext()){//�ж� ���ƶ�ָ��

			String a1 = i1.next();//�ж� �ƶ�ָ��
			if(a1 == "�����"){
				i1.remove(); //ʹ�õ�����������
				i1.add("�찣��");			//	c.Integer  û��add�������ٲ���list������ʹ��add������Ҫʹ��ListIterator
			}		
			System.out.println(a1);
		}
		System.out.println(list1);
	}
}
