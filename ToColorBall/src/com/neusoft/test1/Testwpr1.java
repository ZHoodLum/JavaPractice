package com.neusoft.test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Testwpr1 {

	public static void priorwpr() throws Exception{
		// TODO Auto-generated method stub
	 Connection con=	Test8UtilProperties.getCon();
	 PreparedStatement pst= con.prepareStatement("select * from wpr ");
	 ResultSet rs=pst.executeQuery();
	 List wprList=new ArrayList();
	 while(rs.next()){
		Entitywpr e=new Entitywpr();
		e.setWnumber(rs.getString("wnumber"));
		e.setUnumber(rs.getString("unumber"));
		e.setWname(rs.getString("username"));
		e.setWlevel(rs.getInt("wlevel"));
		wprList.add(e);
	 }
	 Iterator i1= wprList.iterator();
	 while(i1.hasNext()){
		 Entitywpr e=(Entitywpr)i1.next();
		 System.out.println(e);
	 }
	 
	 
	 Test8UtilProperties.close(con, pst);
	 
	}

}
