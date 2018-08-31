package com.neusoft.test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Testtcbi {

	public static void ttcc() throws Exception{
		// TODO Auto-generated method stub
	 Connection con=	Test8UtilProperties.getCon();
	 PreparedStatement pst= con.prepareStatement("select * from tcbi ");
	 ResultSet rs=pst.executeQuery();
	 List consumList=new ArrayList();
	 while(rs.next()){
		Entitytcbi e=new Entitytcbi();
		e.setUsername(rs.getString("username"));
		e.setPassword(rs.getString("password"));
		e.setEmail(rs.getString("email"));
		e.setMoney(rs.getDouble("money"));
		e.setGrantuse(rs.getInt("grantuse"));
		consumList.add(e);
	 }
	 Iterator i1= consumList.iterator();
	 while(i1.hasNext()){
		 Entitytcbi e=(Entitytcbi)i1.next();
		// if(e.getName().equals("SCOTT")){
		// System.out.println(e.getEname()+e.getSal()+e.getDeptno());
		// }
		 System.out.println(e);
	 }
	 
	 
	 Test8UtilProperties.close(con, pst);
	 
	}

}
