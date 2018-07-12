package com.neusoft.oraclejdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=OracleTest5Util.getConnection();//使用工具类 帮我们 省掉了 1 2固定的步骤
			//执行查询 sort 表信息
		PreparedStatement prestatement;
		try {
			prestatement = con.prepareStatement("select * from users where username = ? and password= ? ");
		
		prestatement.setObject(1,"a" );
		prestatement.setObject(2,"1" );
		
		ResultSet resultSet=prestatement.executeQuery();
		
//		int row=statement.executeUpdate("insert into sort values(11,'电吹风',998, '冷热两档的电吹风')");
		
		//5.处理结果     resultSet.next()----> true   false
//		while(resultSet.next()){     
//			//序列从1开始
//			System.out.println(resultSet.getString(2)  +"  "+ resultSet.getString(3));
//		
//		} 
		//6.关闭链接
	
		if(resultSet.next()){
			System.out.println("登陆成功！");
		}else{
			System.out.println("登录失败用户名或密码错误！");
		}
		
	
		OracleTest5Util.closeConnection(prestatement, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
