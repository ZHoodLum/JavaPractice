package com.neusoft.test0723JiHe;

import java.util.Iterator;
import java.util.TreeSet;

public class Test7treeset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * ����  ����˳�������˳��ͬ  ��������  �����ظ�  �����ʱ�� ˳���Ѿ����к� 
		 * ���˳���պ������ŵ� ��һ����״�ṹ
		 * 
		 *  ��״�ṹ  
		 */
		
		/**
		 * ��������ʣ�
		 * �ڵ���ɫ�Ǻ졢��ɫ
		 * ���ڵ��Ǻ�ɫ��
		 * ÿ��Ҷ�ڵ㣨NIL�ڵ㣬�սڵ㣩�Ǻ�ɫ��
		 * ÿ����ɫ�ڵ�������ӽڵ㶼�Ǻ�ɫ�ģ���ÿ��Ҷ�ӵ���������·�����������������ĺ�ɫ�ڵ㣩
		 * ����һ�ڵ㵽��ÿ��Ҷ�ӵ�����·����������ͬ��Ŀ�ĺ�ɫ�ڵ㡣
		 * 
		 */
		TreeSet t = new TreeSet();
				
		t.add(2);
		t.add(22);
		t.add(23);
		t.add(28);
		t.add(92);
		
		Iterator i = t.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
	}

}
