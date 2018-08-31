package com.neusoft.test1;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Test8UtilProperties {

	private static String url;
	private static String username;
	private static String password;
	private static String driverClass;
	private static Connection con;
	static {
		try{
			readPropertiesConfig();
		 Class.forName(driverClass); 
		  Test8UtilProperties.con=DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			System.out.println(e+"oracle数据库连接失败");
		}
		
	}
	
	public static void readPropertiesConfig() throws Exception{
		// TODO Auto-generated method stub
	InputStream in=	Test8UtilProperties.class.getClassLoader().getResourceAsStream("com/neusoft/test1/OracleJdbcManager.properties");
	Properties pro=new Properties();
	 pro.load(in);	
	 url=pro.getProperty("url");
	 username=pro.getProperty("username");
	 password=pro.getProperty("password");
	driverClass=pro.getProperty("driverClass");
	}
	
	
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
