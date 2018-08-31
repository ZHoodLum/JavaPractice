package com.neusoft.test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class Test1 {
	
	static String username;
	static String password;
	static String email;
	static Scanner src= new Scanner(System.in);
	
	public static void main(String[] args) throws Exception  {
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
			boolean flag=true;
		while(flag){
			homePage();
			int lo=src.nextInt();
			switch(lo){
			case 1 : UserLogin.userLogin(); break;
			case 2 : Manage.mngHomepage(); break;
			case 3 : Login.login();break;
			default : System.out.println("输入错误");
			}
			System.out.println("*****退出游戏按0*****");
			int t=src.nextInt();
			if(t==0) flag=false;
		}
			
	}
			
	
	
	public static void homePage(){
		System.out.println("----------中国福利彩票双色球---------");
		System.out.println("--------------首页---------------");
		System.out.println("1.用户登录");
		System.out.println("2.管理员登录");
		System.out.println("3.注册");
	}

}
