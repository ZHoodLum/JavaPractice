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
			System.out.println("^^^^^^^^^^^����Ա�˵�^^^^^^^^^^^^^\n");
			System.out.println("1.�û�������Ϣ����");
			System.out.println("2.�û�������Ϣ����");
			System.out.println("3.�û��н���Ϣ����");
			System.out.println("4.�����û���¼");
			
			int x=src.nextInt();
			switch(x){
			case 1: fonc1(); break;
			case 2: fonc2(); break;
			case 3: fonc3(); break;
			case 4: fonc4(); break;
			}
			System.out.println("*****���ص�¼���水0*****");
			int t=src.nextInt();
			if(t==0) flag=false;
		}
	}
	
	public static void mnglogin(){
		while(true){
			String mngname="";
			String mngpass="";
			Scanner src = new Scanner(System.in);
			System.out.println("-----------����Ա��¼----------");
			System.out.print("�˺ţ�");
			mngname=src.next();
			System.out.print("���룺");
			mngpass=src.next();
			if(mngname.equals("tom")&&mngpass.equals("0001")){
				System.out.println("\n�װ���"+mngname+"����Ա����ӭ���ĵ�½��\n");
				break;
			}else{
				System.out.println("�˺Ż��������");
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
		System.out.println("�������û���");
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
			System.out.println("\nȨ���޸ĳɹ���\n");
			state.close();
		}else{	
			
			System.out.println("\n�û������ڣ�\n");

		}
	}

}
