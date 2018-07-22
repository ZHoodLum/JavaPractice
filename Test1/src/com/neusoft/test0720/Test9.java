package com.neusoft.test0720;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test9 {
	public static void main(String[] args) throws java.text.ParseException {
        System.out.println(" ‰»ÎÃÏ ˝£∫");
        Scanner scan = new Scanner(System.in);
        int day = scan.nextInt();
        String createDate = "2000-01-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date = sdf.parse(createDate);
            Calendar cl = Calendar.getInstance();
            cl.setTime(date);
            // cl.set(Calendar.DATE, day);
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
