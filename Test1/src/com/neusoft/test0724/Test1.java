package com.neusoft.test0724;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
	/**
	 * Map
	 */
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("�Լ�", "�󼪴���");
		map.put("�Լ�", "�´Σ�");
		map.put("ѩ", "Ѫ");

		map.get("�Լ�");
		/**
		 * һ��һ����
		 * k ֵ�����ظ� value���ظ� ����ĻḲ��ǰ���  value�����ֵ��ʹ
		 * ����˵������������  �ǹ���������
		 * map.put(k, value);
		 * ͨ��kֵ �ҵ�valueֵ
		 * ����ͬ��kֵ  ֻ��ȡ����һ��valueֵ
		 * 
		 */
		System.out.println(map.get("�Լ�"));
//		System.out.println(map.get("�󼪴���"));
		
		
		System.out.println("---------------");
		/**
		 * һ�޶����
		 * value���ظ�
		 * kֵ���ظ�
		 */
		map.put("������", "������");
		map.put("�Ά���", "������");
		
		System.out.println(map.get("������"));
		System.out.println(map.get("�Ά���"));
		
		
	}
	
	
	
	
}
