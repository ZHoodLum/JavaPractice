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
	
	public static int moneyT() throws Exception{	//��ѡʽ��Ͷע����������Ǯ
			int a=0; //�ж�����㲻�㣬Ҫ��Ҫ��������
			while(true){	//������������һֱ�������룬ֱ��������ȷ����
				System.out.print("\nͶע��������1-99��");
				Scanner src = new Scanner(System.in);
				multiple=src.nextInt();
				if(multiple>99||multiple<1){
					System.out.println("\n���뱶������");
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
					System.out.println("\n�������㣡���ȳ�ֵ��");
					a=1;
				}else{
					Consumer.Cons(amoney, 0.0,0.0);	//�������ѱ��¼
					amoney=rs.getDouble("money")-amoney;
					Statement state = con.createStatement();
					state.executeUpdate("update tcbi set money ="+amoney+"   where username ='"+UserLogin.username+"'");
					DecimalFormat df=new DecimalFormat("###,###,##0.00");
					String value=df.format(amoney);
					System.out.println("\n����ɹ����������Ϊ:"+value);
					con.commit(); 
					TowColorUtil.close( con, state);	
					a=0;
				}
			}
			rs.close();
			pstate.close();
			return a;
	}
	
	public static int moneyF(int s) throws Exception{	//��ѡʽǮ
		int a=0; //�ж�����㲻�㣬Ҫ��Ҫ��������  a=0���㣬a=1����
		amoney = (double)s*2;
		Connection con =null;	
		con=TowColorUtil.getCon();
		PreparedStatement pstate =con.prepareStatement("select money from tcbi where username ='"+UserLogin.username+"' ");
		ResultSet rs = pstate.executeQuery();
		if(rs.next()){
			if(amoney>=rs.getDouble("money")){
				System.out.println("\n�������㣡���ȳ�ֵ��");
				a=1;
			}else{
				Consumer.Cons(amoney, 0.0,0.0);	//�������ѱ��¼
				amoney=rs.getDouble("money")-amoney;
				Statement state = con.createStatement();
				state.executeUpdate("update tcbi set money ="+amoney+"   where username ='"+UserLogin.username+"'");
				DecimalFormat df=new DecimalFormat("###,###,##0.00");
				String value=df.format(amoney);
				System.out.println("\n����ɹ����������Ϊ:"+value);
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
		System.out.println("\n\n��ϲ������һ�Ƚ�������"+value+"Ԫ���Ѽ�ʱ���������˻����뾡������!");
		updatemoney(t);	
	}
	public static void money2() throws Exception{
		Double t =(double)1000000; 
		DecimalFormat df=new DecimalFormat("###,###,##0.00");
		String value=df.format(t);
		System.out.println("\n\n��ϲ�������˶��Ƚ�������"+value+"Ԫ���Ѽ�ʱ���������˻����뾡������");
		updatemoney(t); //һ��ר�Ÿ����˻����ķ���
	}
	public static void money3() throws Exception{
		Double t =(double)3000*multiple; 
		DecimalFormat df=new DecimalFormat("###,###,##0.00");
		String value=df.format(t);
		System.out.println("\n\n��ϲ�����������Ƚ�������"+value+"Ԫ���Ѽ�ʱ���������˻����뾡������");
		updatemoney(t);
	}
	public static void money4() throws Exception{
		Double t =(double)200*multiple; 
		DecimalFormat df=new DecimalFormat("###,###,##0.00");
		String value=df.format(t);
		System.out.println("\n\n��ϲ���������ĵȽ�������"+value+"Ԫ���Ѽ�ʱ���������˻����뾡������");
		updatemoney(t);
	}
	public static void money5() throws Exception{
		Double t =(double)10*multiple; 
		DecimalFormat df=new DecimalFormat("###,###,##0.00");
		String value=df.format(t);
		System.out.println("\n\n��ϲ����������Ƚ�������"+value+"Ԫ���Ѽ�ʱ���������˻����뾡������");
		updatemoney(t);
	}
	public static void money6() throws Exception{
		Double t =(double)5*multiple; 
		DecimalFormat df=new DecimalFormat("###,###,##0.00");
		String value=df.format(t);
		System.out.println("\n\n��ϲ�����������Ƚ�������"+value+"Ԫ���Ѽ�ʱ���������˻����뾡������");
		updatemoney(t);
	}
	

	//ר�Ÿ����˻����
	private static void updatemoney(Double t) throws Exception{
		Connection con =null;	
		con=TowColorUtil.getCon();
		Statement state = con.createStatement();
		PreparedStatement pstate =con.prepareStatement("select money from tcbi where username ='"+UserLogin.username+"' ");
		ResultSet rs = pstate.executeQuery();
		Consumer.Cons(t, 0.0,0.0);	//�������ѱ��¼
		if(rs.next()){
			amoney=rs.getDouble("money")+t;
			DecimalFormat df=new DecimalFormat("###,###,##0.00");
			String value=df.format(amoney);
			System.out.println("\n�����˻���"+value);
		}
		state.executeUpdate("update tcbi set money ="+amoney+"   where username ='"+UserLogin.username+"'");
		con.commit(); 
	}
	
	//���������н�ʱ��¼��wpr
	public static void insertw0(int[] number,int wlevel) throws Exception{
		Connection con =null;	
		con=TowColorUtil.getCon();
		String wnumber=Arrays.toString(number);
		String unumber=Arrays.toString(Game.user);
		Statement state =con.createStatement();		   
		int row = state.executeUpdate("insert into wpr (wnumber,unumber,username,wlevel) values('"+wnumber+"','"+unumber+"','"+UserLogin.username+"','"+wlevel+"')");
		System.out.println("WPR����һ���н��˼�¼��");	
		TowColorUtil.close(con, state);
	}
	
	//���������н�ʱ��¼��wpr
	public static void insertw1(int[] number) throws Exception{
		Connection con =null;	
		con=TowColorUtil.getCon();
		String numstr=Arrays.toString(number);
		Statement state =con.createStatement();		  
		int row = state.executeUpdate("insert into wpr (wnumber) values('"+numstr+"')");
		System.out.println("wpr����һ���޽��˼�¼��");	
		TowColorUtil.close(con, state);
	}
}
