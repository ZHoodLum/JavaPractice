package com.neusoft.test0723JiHe;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test6HashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * TreeSet
		 * 
		 * HashSet   ���� �����ظ�   ���ʱ��������  ����ʹ��mainֵ
		 * ���equlesֵ���  ��ôHashcodeֵһ�����
		 * ����Hash  ���������
		 * 
		 * 
		 */
		
		Set s = new HashSet();
		
		s.add("aaa");
		s.add("bbb");
		s.add("ccc");
		s.add("ddd");
		
		Iterator i = s.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
	}

}
