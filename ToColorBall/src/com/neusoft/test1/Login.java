package com.neusoft.test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
	
	static String username;
	static String password;
	static String email;
	static Scanner src= new Scanner(System.in);

	public static void login() throws Exception {
		boolean flag=true;
		while(flag){
			System.out.println("----------�û�ע��------------");
			System.out.print("�û�����");
			username=src.next();
			System.out.println("���룺");
			password=src.next();
			System.out.println("���䣺");
			email=src.next();
		
			String mailRegEx="\\d{3,8}@qq+\\.(com)";
			Pattern mailPattern=Pattern.compile(mailRegEx);
			Matcher matcher=null;
			if(matcher==null){
				matcher=mailPattern.matcher(email);
			}else{
				matcher.reset(email);
			}
			if(!matcher.matches()){
				System.out.println("\n�����׺@qq.com");
			}else{
				
				
				Connection con =null;	
				con=TowColorUtil.getCon();	
				PreparedStatement pstate =con.prepareStatement("select username,email from tcbi where username ='"+username+"' or email = '"+email+"' ");
				ResultSet rs = pstate.executeQuery();
				if(rs.next()){
					System.out.println("\n�û����������Ѵ��ڣ�\n");
				}else{	
					Statement state =con.createStatement();
					int row = state.executeUpdate("insert into tcbi(username,password,email) values('"+username+"','"+password+"','"+email+"')");
					System.out.println("ע��ɹ�!\n�װ���"+username+"�û����й�������Ʊ��ӭ����\n");
					flag=false;
					UserLogin.userLogin();
				}
			}
		}
	}
}
