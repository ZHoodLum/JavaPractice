package com.neusoft.test0720;

import java.util.Calendar;

public class Calender {
	public static void main(String[] args) {
		Calendar c1 = Calendar.getInstance();
		
		c1.set(2012, 2,8);
		
		System.out.print(c1.get(1));
		
		//˲����ú���ֵ����ʾ�����Ǿ���Ԫ�����������α�׼ʱ�� 1970 �� 1 �� 1 �յ� 00:00:00.000���������������ƫ������
		//��ȡ��Ӧ����
		//���ָ��������ʱ����ĵڼ���
		System.out.print(c1.get(Calendar.DAY_OF_YEAR));
	
	}
}
