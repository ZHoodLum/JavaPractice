package com.neusoft.test0720;

import java.util.Calendar;

public class Calender {
	public static void main(String[] args) {
		Calendar c1 = Calendar.getInstance();
		
		c1.set(2012, 2,8);
		
		System.out.print(c1.get(1));
		
		//瞬间可用毫秒值来表示，它是距历元（即格林威治标准时间 1970 年 1 月 1 日的 00:00:00.000，格里高利历）的偏移量。
		//获取对应数据
		//获得指定年月日时当年的第几天
		System.out.print(c1.get(Calendar.DAY_OF_YEAR));
	
	}
}
