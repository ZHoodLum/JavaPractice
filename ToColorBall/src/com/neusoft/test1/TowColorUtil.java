package com.neusoft.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TowColorUtil {   //做一个Oracle工具类

	static {
		try{
		 Class.forName("oracle.jdbc.driver.OracleDriver"); 
		  String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl"; 
		  String username="scott";
		  String password="tiger";
		  TowColorUtil.con=DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			System.out.println(e+"oracle数据库连接失败");
		}
		
	}
	
      private	static Connection con;
	  public static Connection getCon() {
		return con;
	  }
	  public static void closeQuery(ResultSet rs,Connection con,Statement state) throws Exception{  
		  if(rs!=null){
			  rs.close();
		  }
		  if(state!=null){
			  state.close();
		  }
		  if(con!=null){
			  state.close();
		  }
	  }
	  public static void close(Connection con,Statement state) throws Exception{
		   
		  if(state!=null){
			  state.close();
		  }
		  if(con!=null){
			  state.close();
		  } 
	  }
	  public static void closezz(Connection con,Statement state,Statement state1) throws Exception{
		  if(state1!=null){
			  state1.close();
		  }
		  if(state!=null){
			  state.close();
		  }
		  if(con!=null){
			  state.close();
		  } 
	  }
	
}
