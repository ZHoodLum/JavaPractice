package com.neusoft.test0720;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HTest1 {
	public static void main(String[] args) throws ParseException {
//		Scanner s = new Scanner(System.in);
//		System.out.println("���������ڣ��磺2017-2-9");
//		String rq1 = s.next();
//		String rq2 = s.next();
//		//����ģ��
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date d1 = sdf.parse(rq1);
//		Date d2 = sdf.parse(rq2);
		
//		//�ж����ڴ�С
//		if(d1.compareTo(d2)>0){
//			System.out.println(rq1+"����"+rq2);
//		}else if (d1.compareTo(d2)<0){
//			System.out.println(rq1+"С��"+rq2);
//		}else{
//			System.out.println(rq1+"����"+rq2);
//		}

		//�ж����ڴ�С
		Date d1 = new Date(3,3,2033);
		Date d2 = new Date(3,3,2099);
		if(d1.before(d2)){
			System.out.println(d1+"С��"+d2);
		}else{
			System.out.println(d1+"����"+d2);
		}

		
		
	}
}
