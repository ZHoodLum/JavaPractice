package com.neusoft.test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Testcs {

	public static void consum() throws Exception{
		// TODO Auto-generated method stub
	 Connection con=	Test8UtilProperties.getCon();
	 PreparedStatement pst= con.prepareStatement("select * from consum ");
	 ResultSet rs=pst.executeQuery();
	 List consumList=new ArrayList();
	 while(rs.next()){
		Entitycs e=new Entitycs();
		e.setName(rs.getString("name"));
		e.setPay(rs.getDouble("pay"));
		e.setGain(rs.getDouble("gain"));
		e.setWard(rs.getDouble("ward"));
		e.setDate(rs.getDate("time"));
		consumList.add(e);
	 }
	 Iterator i1= consumList.iterator();
	 while(i1.hasNext()){
		 Entitycs e=(Entitycs)i1.next();
		// if(e.getName().equals("SCOTT")){
		// System.out.println(e.getEname()+e.getSal()+e.getDeptno());
		// }
		 System.out.println(e);
	 }
	 
	 
	 Test8UtilProperties.close(con, pst);
	 
	}

}
