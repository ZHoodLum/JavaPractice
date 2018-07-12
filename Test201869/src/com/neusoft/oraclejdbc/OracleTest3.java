package com.neusoft.oraclejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OracleTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String au = sc.next();
		System.out.println("请输入密码:");
		String ap = sc.next();
		
//		java 使用jdbc连接oralce数据库
//		1.注册驱动   ps:Oracle与MySQL注册驱动时 是不同的
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		2.定义连接url  建立连接  --> url username password    ps:不同的数据库 不同的地址 内容不同
		
		//@后面   是  ：远程连接或本地连接的ip地址     orcl
		String url="jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
		
		//输入Oracle的用户名 密码
		String username="scott";
		String password="tiger";
		
		//连接 ps:捕获异常
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println(con);
			
			//3.获取执行sql语句的平台  1.statement（会出现sql注入问题） 2.prestatement   ps:常用第一个
			Statement statement=con.createStatement();
			
//			4.写执行的sql语句 包括增删改查
//			statement.executeQuery("select * from sort");
			//添加
//			int row = statement.executeUpdate("insert into sort values(1,'无锡','99','冷啊')");
			//查询
			ResultSet re = statement.executeQuery("select * from users where username = '"+au+"' and password + '"+ap+"'");
			
//			5.处理结果  
			//添加
//			System.out.println("re"+re);
			//查询遍历
//			while(re.next()) {
//				System.out.println(re.getInt("id")+" "+
//						re.getString("username")+" "+
//						re.getString("password")
//						);
//			}
			//进行登录
			if(re.next()) {
				System.out.println("登陆成功！");
			}else {
				System.out.println("登陆错误！");
			}
			
			
			
			
			
//			6.关闭连接
			statement.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
