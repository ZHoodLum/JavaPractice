package com.neusoft.test0720;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class HTest2 {
	public static void main(String[] args) throws ParseException {
		Scanner s = new Scanner(System.in);
		System.out.println("��������Ʒ�������ڣ��磺2017-2-9");
		String rq1 = s.next();
		int day = s.nextInt();

		//����ģ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse(rq1);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new Date();//�õ���ǰʱ��
		String str="2018-7-20";
		Date d2 = sdf1.parse(str);
//		System.out.println();
		
		//�ж����ڴ�С
		if(d1.compareTo(d2)>0){
			System.out.println("����Ʒ�ѹ���!");
		}else{
			try {
	            Date date = sdf.parse(str);
	            Calendar cl = Calendar.getInstance();
	            cl.setTime(date);
	            cl.add(Calendar.DATE, day);
	            String temp = "";
	            temp = sdf.format(cl.getTime());
	            System.out.println(temp);
	        } catch (ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
			
		}

	}
}
