package com.neusoft.test0713;

import java.text.ParseException;
import java.util.Arrays;
import java.util.TreeSet;

public class trangle6 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
	/*	��2����ά����ֱ��� 2 3 4   ��  1 5 2 8 
        4 6 8       5 9 10 -3 
                    2 7 -5 -18
�������·�ʽ�������㡣����һ��2��4�е����顣������ĵ�1��1����2*1+3*5+4*2��1��2����2*5+3*9+4*7  ��2��1����4*1+6*5+8*2 �������ơ���֪ʶ�㣺��ά���鶨��ʹ������������������Ԫ�ط��ʣ� [ѡ����]

2����һ�������е�Ԫ��������
*/

//		��һ�������е��ظ�Ԫ�ر���һ������������
	        String[] a ={"1","2","2","3","3","3","6"};
	        TreeSet ts = new TreeSet();
	        for(String s:a) {
	            ts.add(s);
	        }
	        String[] array = (String[])ts.toArray(new String[]{});
	        System.out.println(Arrays.toString(array));
	 
	}

}
