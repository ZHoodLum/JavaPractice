package com.neusoft.test1;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;

public class Consumer {

	public static void Cons(Double pay,Double ward,Double gain )throws Exception{
			Connection con =null;	
			con=TowColorUtil.getCon();
			Statement state =con.createStatement();		   
			int row = state.executeUpdate("insert into consum (name,pay,ward,gain,time) values('"+UserLogin.username+"','"+pay+"','"+ward+"','"+gain+"',sysdate)");
			System.out.println("consum表插入一条消费记录！");	
			TowColorUtil.close(con, state);
		
	}
}
