package com.neusoft.test0720;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HTest1 {
	public static void main(String[] args) throws ParseException {
//		Scanner s = new Scanner(System.in);
//		System.out.println("请输入日期：如：2017-2-9");
//		String rq1 = s.next();
//		String rq2 = s.next();
//		//输入模板
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date d1 = sdf.parse(rq1);
//		Date d2 = sdf.parse(rq2);
		
//		//判定日期大小
//		if(d1.compareTo(d2)>0){
//			System.out.println(rq1+"大于"+rq2);
//		}else if (d1.compareTo(d2)<0){
//			System.out.println(rq1+"小于"+rq2);
//		}else{
//			System.out.println(rq1+"等于"+rq2);
//		}

		//判定日期大小
		Date d1 = new Date(3,3,2033);
		Date d2 = new Date(3,3,2099);
		if(d1.before(d2)){
			System.out.println(d1+"小于"+d2);
		}else{
			System.out.println(d1+"大于"+d2);
		}

		
		
	}
}
