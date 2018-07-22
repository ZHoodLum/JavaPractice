package com.neusoft.test0720;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test8 {
	public static void main(String[] args) throws ParseException{
//		当前系统时间
		Date d = new Date();
		System.out.println(d);
		Date d1 = new Date(3,3,2033);
		//当前时间是否在d1指定时间之后
		System.out.println(d.after(d1));
		System.out.println(d.before(d1));
		//大小
		System.out.println(d.compareTo(d1));
		
		
		System.out.println(d.getTime());
		System.out.println(d.getDate());
		
		d.setTime(01);
		//当前系统时间中国是UTC+8所开始的时间  1970.1.1 08：00：00
		//当前系统时间为UTC  世界标准时间  1970.1.1 08：00：00
		System.out.println(d);
		//设置的long值实际上是距离 1970.1.1 08：00：00  的毫秒数
		d.setTime(10001);
		System.out.println(d);

		
		/**
		 * CHina
		 * date转换为String类型
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS zz");//时间格式
		Date nowDate = new Date();//得到当前时间
		String date = sdf.format(nowDate );
		System.out.println(date);
		
		/**
		 * String转换为date类型
		 */
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");//时间格式
		String str="2008-7-7";
		Date d2 = sdf1.parse(str);
		System.out.println(str);
		
		
		
		
	}

}
