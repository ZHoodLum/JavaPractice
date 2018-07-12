package com.neusoft.oraclejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OracleTest4 {

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
			
			//3.获取执行sql语句的平台  1.statement（会出现sql注入问题） 2.preparestatement   ps:常用第一个 
//			使用prepareStatement
			PreparedStatement pr = con.prepareStatement("select * from users where username = ? and password = ?");
			
			pr.setObject(1, au);
			pr.setObject(2, ap);
			
//			4.写执行的sql语句 包括增删改查
			//查询
			ResultSet re = pr.executeQuery();
			
//			5.处理结果  
			//进行登录
			if(re.next()) {
				System.out.println("登陆成功！");
			}else {
				System.out.println("登陆错误！");
			}
//			6.关闭连接
			pr.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
