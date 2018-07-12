package com.neusoft.mysqljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		java 使用jdbc连接mysql数据库
//		1.注册驱动   ps:Oracle与MySQL注册驱动时 是不同的
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		2.定义连接url  建立连接  --> url username password    ps:不同的数据库 不同的地址 内容不同
		
		//@后面   是  ：远程连接或本地连接的ip地址     orcl
		String url="jdbc:mysql://localhost:3306/db8";
//		String url="jdbc:mysql://127.0.0.1:3306/db8";
		
		//输入mysql的用户名 密码
		String username="root";
		String password="root";
		
		//连接 ps:捕获异常
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println(con);
			
//			3.获取执行sql语句的平台  1.statement（会出现sql注入问题） 2.prestatement   ps:常用第一个
			Statement statement=con.createStatement();
			
//			4.写执行的sql语句 包括增删改查
//			statement.executeQuery("select * from sort");
			int row = statement.executeUpdate("insert into sort values(8,'无锡','99','冷啊')");
			
//			5.处理结果
			System.out.println("row"+row);
			
//			6.关闭连接
			statement.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
