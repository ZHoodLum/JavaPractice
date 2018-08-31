package com.neusoft.test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Manage {
	static boolean flag=true;
	static Scanner src= new Scanner(System.in);
	public static void mngHomepage() throws Exception{
		
		mnglogin();
		while(flag){
			System.out.println("^^^^^^^^^^^管理员菜单^^^^^^^^^^^^^\n");
			System.out.println("1.用户基本信息管理");
			System.out.println("2.用户消费信息管理");
			System.out.println("3.用户中奖信息管理");
			System.out.println("4.限制用户登录");
			
			int x=src.nextInt();
			switch(x){
			case 1: fonc1(); break;
			case 2: fonc2(); break;
			case 3: fonc3(); break;
			case 4: fonc4(); break;
			}
			System.out.println("*****返回登录界面按0*****");
			int t=src.nextInt();
			if(t==0) flag=false;
		}
	}
	
	public static void mnglogin(){
		while(true){
			String mngname="";
			String mngpass="";
			Scanner src = new Scanner(System.in);
			System.out.println("-----------管理员登录----------");
			System.out.print("账号：");
			mngname=src.next();
			System.out.print("密码：");
			mngpass=src.next();
			if(mngname.equals("tom")&&mngpass.equals("0001")){
				System.out.println("\n亲爱的"+mngname+"管理员，欢迎您的登陆！\n");
				break;
			}else{
				System.out.println("账号或密码错误");
			}
		}
	}
	
	public static void fonc1() throws Exception{
		Testtcbi.ttcc();
	}
	
	public static void fonc2() throws Exception{
		Testcs.consum();
	}
	
	public static void fonc3() throws Exception{
		Testwpr1.priorwpr();	}
	
	public static void fonc4() throws Exception{
		System.out.println("被限制用户：");
		String name = src.next();
		
		Connection con =null;	
		con=TowColorUtil.getCon();	
		PreparedStatement pstate =con.prepareStatement("select username,grantuse from tcbi where username ='"+name+"' ");
		ResultSet rs = pstate.executeQuery();
		if(rs.next()){
			Statement state = con.createStatement();
			if(rs.getInt("grantuse")==1)
				state.executeUpdate("update tcbi set grantuse =0 where username= '"+name+"' ");
			else 
				state.executeUpdate("update tcbi set grantuse =1 where username= '"+name+"' ");

			con.commit(); 
			System.out.println("\n权限修改成功！\n");
			state.close();
		}else{	
			
			System.out.println("\n用户不存在！\n");

		}
	}

}
