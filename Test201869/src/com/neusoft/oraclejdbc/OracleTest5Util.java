package com.neusoft.oraclejdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class OracleTest5Util {
	static Connection con=null;
	static String url;
	static String username;
	static String password;
	
	//静态块   减少代码量 优化代码
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
//			String  username="scott";
//			String password="tiger";
			con = DriverManager.getConnection(url, username, password);
			read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static Connection getConnection(){
		return con;
	} 
	public static Statement getstatment(){
		Statement statement=null;
		try {
			statement= getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statement;
		
	}
	
//    public static PreparedStatement getPrestatment(){
//    	PreparedStatement preparedStatement=null;
//    	
//    	preparedStatement=getConnection().
//    	
//    	
//	}
	
	//读方法
	public static void read() {
		InputStream inputstream = 
				OracleTest5Util.class.getClassLoader().getResourceAsStream("com/neusoft/config/oracledb.properties");
		Properties pr = new Properties();
		try {
			pr.load(inputstream);
			pr.getProperty("url");
			username = pr.getProperty("username");
			password = pr.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void closeConnection(PreparedStatement prestatement,Connection con){
		
		try {
			prestatement.close();
	
		   con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	
	
}
