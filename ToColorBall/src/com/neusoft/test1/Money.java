package com.neusoft.test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Money {
	static Double amoney;
	static int multiple;
	
	public static int moneyT() throws Exception{	//单选式版投注倍数及多少钱
			int a=0; //判断余额足不足，要不要继续开奖
			while(true){	//倍数输入错误会一直重新输入，直到输入正确跳出
				System.out.print("\n投注倍数：（1-99）");
				Scanner src = new Scanner(System.in);
				multiple=src.nextInt();
				if(multiple>99||multiple<1){
					System.out.println("\n输入倍数错误！");
				}else{
					break;
				}
			}
			amoney = (double)multiple*2;
			Connection con =null;	
			con=TowColorUtil.getCon();
			PreparedStatement pstate =con.prepareStatement("select money from tcbi where username ='"+UserLogin.username+"' ");
			ResultSet rs = pstate.executeQuery();
			if(rs.next()){
				if(amoney>=rs.getDouble("money")){
					System.out.println("\n您的余额不足！请先充值！");
					a=1;
				}else{
					Consumer.Cons(amoney, 0.0,0.0);	//更新消费表记录
					amoney=rs.getDouble("money")-amoney;
					Statement state = con.createStatement();
					state.executeUpdate("update tcbi set money ="+amoney+"   where username ='"+UserLogin.username+"'");
					DecimalFormat df=new DecimalFormat("###,###,##0.00");
					String value=df.format(amoney);
					System.out.println("\n购买成功，您的余额为:"+value);
					con.commit(); 
					TowColorUtil.close( con, state);	
					a=0;
				}
			}
			rs.close();
			pstate.close();
			return a;
	}
	
	public static int moneyF(int s) throws Exception{	//复选式钱
		int a=0; //判断余额足不足，要不要继续开奖  a=0充足，a=1不足
		amoney = (double)s*2;
		Connection con =null;	
		con=TowColorUtil.getCon();
		PreparedStatement pstate =con.prepareStatement("select money from tcbi where username ='"+UserLogin.username+"' ");
		ResultSet rs = pstate.executeQuery();
		if(rs.next()){
			if(amoney>=rs.getDouble("money")){
				System.out.println("\n您的余额不足！请先充值！");
				a=1;
			}else{
				Consumer.Cons(amoney, 0.0,0.0);	//更新消费表记录
				amoney=rs.getDouble("money")-amoney;
				Statement state = con.createStatement();
				state.executeUpdate("update tcbi set money ="+amoney+"   where username ='"+UserLogin.username+"'");
				DecimalFormat df=new DecimalFormat("###,###,##0.00");
				String value=df.format(amoney);
				System.out.println("\n购买成功，您的余额为:"+value);
				con.commit(); 
				TowColorUtil.close( con, state);	
				a=0;
			}
		}
		rs.close();
		pstate.close();
		return a;
}
	
	public static void money1() throws Exception{
		Double t =(double)10000000; 
		DecimalFormat df=new DecimalFormat("###,###,##0.00");
		String value=df.format(t);
		System.out.println("\n\n恭喜您中了一等奖！奖金："+value+"元，已及时存入您的账户，请尽快提现!");
		updatemoney(t);	
	}
	public static void money2() throws Exception{
		Double t =(double)1000000; 
		DecimalFormat df=new DecimalFormat("###,###,##0.00");
		String value=df.format(t);
		System.out.println("\n\n恭喜您，中了二等奖！奖金："+value+"元，已及时存入您的账户，请尽快提现");
		updatemoney(t); //一个专门更新账户余额的方法
	}
	public static void money3() throws Exception{
		Double t =(double)3000*multiple; 
		DecimalFormat df=new DecimalFormat("###,###,##0.00");
		String value=df.format(t);
		System.out.println("\n\n恭喜您，中了三等奖！奖金："+value+"元，已及时存入您的账户，请尽快提现");
		updatemoney(t);
	}
	public static void money4() throws Exception{
		Double t =(double)200*multiple; 
		DecimalFormat df=new DecimalFormat("###,###,##0.00");
		String value=df.format(t);
		System.out.println("\n\n恭喜您，中了四等奖！奖金："+value+"元，已及时存入您的账户，请尽快提现");
		updatemoney(t);
	}
	public static void money5() throws Exception{
		Double t =(double)10*multiple; 
		DecimalFormat df=new DecimalFormat("###,###,##0.00");
		String value=df.format(t);
		System.out.println("\n\n恭喜您，中了五等奖！奖金："+value+"元，已及时存入您的账户，请尽快提现");
		updatemoney(t);
	}
	public static void money6() throws Exception{
		Double t =(double)5*multiple; 
		DecimalFormat df=new DecimalFormat("###,###,##0.00");
		String value=df.format(t);
		System.out.println("\n\n恭喜您，中了六等奖！奖金："+value+"元，已及时存入您的账户，请尽快提现");
		updatemoney(t);
	}
	

	//专门更新账户余额
	private static void updatemoney(Double t) throws Exception{
		Connection con =null;	
		con=TowColorUtil.getCon();
		Statement state = con.createStatement();
		PreparedStatement pstate =con.prepareStatement("select money from tcbi where username ='"+UserLogin.username+"' ");
		ResultSet rs = pstate.executeQuery();
		Consumer.Cons(t, 0.0,0.0);	//更新消费表记录
		if(rs.next()){
			amoney=rs.getDouble("money")+t;
			DecimalFormat df=new DecimalFormat("###,###,##0.00");
			String value=df.format(amoney);
			System.out.println("\n您的账户余额："+value);
		}
		state.executeUpdate("update tcbi set money ="+amoney+"   where username ='"+UserLogin.username+"'");
		con.commit(); 
	}
	
	//更新有人中奖时记录表wpr
	public static void insertw0(int[] number,int wlevel) throws Exception{
		Connection con =null;	
		con=TowColorUtil.getCon();
		String wnumber=Arrays.toString(number);
		String unumber=Arrays.toString(Game.user);
		Statement state =con.createStatement();		   
		int row = state.executeUpdate("insert into wpr (wnumber,unumber,username,wlevel) values('"+wnumber+"','"+unumber+"','"+UserLogin.username+"','"+wlevel+"')");
		System.out.println("WPR插入一条有奖人记录！");	
		TowColorUtil.close(con, state);
	}
	
	//更新无人中奖时记录表wpr
	public static void insertw1(int[] number) throws Exception{
		Connection con =null;	
		con=TowColorUtil.getCon();
		String numstr=Arrays.toString(number);
		Statement state =con.createStatement();		  
		int row = state.executeUpdate("insert into wpr (wnumber) values('"+numstr+"')");
		System.out.println("wpr插入一条无奖人记录！");	
		TowColorUtil.close(con, state);
	}
}
