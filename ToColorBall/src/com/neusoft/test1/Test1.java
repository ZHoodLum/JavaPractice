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
			default : System.out.println("�������");
			}
			System.out.println("*****�˳���Ϸ��0*****");
			int t=src.nextInt();
			if(t==0) flag=false;
		}
			
	}
			
	
	
	public static void homePage(){
		System.out.println("----------�й�������Ʊ˫ɫ��---------");
		System.out.println("--------------��ҳ---------------");
		System.out.println("1.�û���¼");
		System.out.println("2.����Ա��¼");
		System.out.println("3.ע��");
	}

}
