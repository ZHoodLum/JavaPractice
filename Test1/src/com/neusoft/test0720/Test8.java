package com.neusoft.test0720;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test8 {
	public static void main(String[] args) throws ParseException{
//		��ǰϵͳʱ��
		Date d = new Date();
		System.out.println(d);
		Date d1 = new Date(3,3,2033);
		//��ǰʱ���Ƿ���d1ָ��ʱ��֮��
		System.out.println(d.after(d1));
		System.out.println(d.before(d1));
		//��С
		System.out.println(d.compareTo(d1));
		
		
		System.out.println(d.getTime());
		System.out.println(d.getDate());
		
		d.setTime(01);
		//��ǰϵͳʱ���й���UTC+8����ʼ��ʱ��  1970.1.1 08��00��00
		//��ǰϵͳʱ��ΪUTC  �����׼ʱ��  1970.1.1 08��00��00
		System.out.println(d);
		//���õ�longֵʵ�����Ǿ��� 1970.1.1 08��00��00  �ĺ�����
		d.setTime(10001);
		System.out.println(d);

		
		/**
		 * CHina
		 * dateת��ΪString����
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS zz");//ʱ���ʽ
		Date nowDate = new Date();//�õ���ǰʱ��
		String date = sdf.format(nowDate );
		System.out.println(date);
		
		/**
		 * Stringת��Ϊdate����
		 */
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//ʱ���ʽ
		String str="2008-7-7";
		Date d2 = sdf1.parse(str);
		System.out.println(str);
		
		
		
		
	}

}
