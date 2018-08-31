package com.neusoft.test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class OraTest8 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	 Connection con=	Test8UtilProperties.getCon();
	 PreparedStatement pst= con.prepareStatement("select * from emp where deptno=20");
	 //查询 emp中20部门 ename,sal,deptno
	 ResultSet rs=pst.executeQuery();
	 List empList=new ArrayList();
	 while(rs.next()){
		Employeer e=new Employeer();
		e.setEname(rs.getString("ename"));
		e.setSal(rs.getDouble("sal"));
		e.setDeptno(rs.getInt("deptno"));
		empList.add(e);
//		 System.out.println(rs.getString("ename")+","+rs.getDouble("sal")+rs.getInt("deptno"));
	 }
	 Iterator i1= empList.iterator();
	 while(i1.hasNext()){
		 Employeer e=(Employeer)i1.next();
		 if(e.getEname().equals("SCOTT")){
		 System.out.println(e.getEname()+e.getSal()+e.getDeptno());
		 }
	 }
	 
	 
	Test8UtilProperties.close(con, pst);
	 
	}

}
