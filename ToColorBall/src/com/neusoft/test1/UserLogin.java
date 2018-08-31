package com.neusoft.test1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Scanner;

public class UserLogin {
	
	static String username;	//�û���
	static String password;	//����
	static String email;	//����
	static Double money;	//���
	static boolean flg; //�˳�
	static Scanner src= new Scanner(System.in);
	
	//�û���¼
	public static void userLogin() throws Exception{	
		flg=true;
		Connect();	//��֤�û����������Ƿ���ȷ
		while(flg){	//��¼�ɹ���һֱ�������ҳ�棬ֱ����0�˳�
		System.out.println("^^^^^^^^^^^�û��˵�^^^^^^^^^^^^^");
		System.out.println("1.�鿴��Ϣ");
		System.out.println("2.�޸���Ϣ");
		System.out.println("3.����ֵ");
		System.out.println("4.��Ϸ����");
		System.out.println("5.�鿴���Ѽ�¼");
		System.out.println("6.�鿴�н���¼");
		System.out.println("7.�鿴�����н�����");
		int x=src.nextInt();
		switch(x){
			case 1: Look(); break;
			case 2: Update(); break;
			case 3: Money(); break;
			case 4: Gameroom(); break;
			case 5: Consume(); break;
			case 6: Happy(); break;
			case 7: Prior(); break;
		}
		System.out.println("*****������ҳ�밴0*****");
		int t=src.nextInt();
		if(t==0) flg=false;
		}
	}
	     
	//�û���¼��֤�û����������Ƿ���ȷ
	private static void Connect() throws Exception{	
		while(true){	//һֱ��½��ֱ����¼�ɹ�����
		System.out.println("-----------�û���¼------------");
		System.out.print("�û�����");
		username =src.next();
		System.out.print("���룺");
		password = src.next();
		
		Connection con =null;	
		con=TowColorUtil.getCon();
		PreparedStatement pstate =con.prepareStatement("select username,password,grantuse from tcbi where username ='"+username+"' and password = '"+password+"' ");
		ResultSet rs = pstate.executeQuery();
		if(rs.next()){
			if(rs.getInt("grantuse")==1){
				System.out.println("\n�װ���"+username+"�û�����ӭ���ĵ�¼��\n");
				break;
			}else{
				System.out.println("���ѽ�ֹ��¼���������Ա��ϵ��\n");
			}
		}else{
			System.out.println("\n�û������������\n");
		}
		TowColorUtil.closeQuery(rs, con, pstate);
		}	
	}
	
	//�鿴�û���Ϣ
	private static void Look() throws Exception{		
		Connection con =null;	
		con=TowColorUtil.getCon();
		PreparedStatement pstate =con.prepareStatement("select username,password,email from tcbi where username ='"+username+"' and password = '"+password+"' ");
		ResultSet rs = pstate.executeQuery();	
		if(rs.next()){
			System.out.println("�û�����"+rs.getString("username")+"  ���룺"+rs.getString("password")+"  ���䣺"+rs.getString("email"));
		}else{
			System.out.println("�û������ڣ�\n");
		}
		TowColorUtil.closeQuery(rs, con, pstate);
	}
	
	//�޸��û���Ϣ
	public static void Update() throws Exception{			
		String pname=username;
		System.out.println("----------�޸Ļ�����Ϣ------------");
		System.out.print("�û�����");
		username=src.next();
		System.out.println("���룺");
		password=src.next();
		System.out.println("���䣺");
		email=src.next();
	
		Connection con =null;	
		con=TowColorUtil.getCon();
		PreparedStatement pstate =con.prepareStatement("select username,email from tcbi where username ='"+username+"' or email = '"+email+"' ");
		ResultSet rs = pstate.executeQuery();
		if(rs.next()){
			System.out.println("\n�û����������Ѵ��ڣ�\n");
		}else{		
			Statement state = con.createStatement();
			state.executeUpdate("update tcbi set username ='"+username+"' , password = '"+password+"' , email =  '"+email+"'  where username= '"+pname+"' ");
			con.commit(); 
			System.out.println("\n�޸ĳɹ���\n");
			state.close();
		}
		TowColorUtil.closeQuery(rs, con, pstate);
	}
	
	//����ֵ
	public static void Money() throws Exception{    
		Connection con =null;	
		con=TowColorUtil.getCon();
		PreparedStatement pstate =con.prepareStatement("select money from tcbi where username ='"+username+"' ");
		ResultSet rs = pstate.executeQuery();
		if(rs.next()){
			money=rs.getDouble("money");
			DecimalFormat df=new DecimalFormat("###,###,##0.00");
			String value=df.format(money);
			System.out.println("�������Ϊ:"+value);
		}
		System.out.println("�Ƿ��ֵ ������1ȷ�ϣ�");
		int qr=src.nextInt();
		if(qr==1){
			System.out.println("��ֵ��");
			Double n=src.nextDouble();
			Double m=n+money;
			Statement state = con.createStatement();
			state.executeUpdate("update tcbi set money ="+m+" where username ='"+username+"'");
			System.out.println("\n��ֵ�ɹ���\n");
			Consumer.Cons(0.0,0.0, n);	//�������ѱ��¼
			con.commit(); 
			TowColorUtil.closezz( con, state,pstate);
			rs.close();
		}	
	}
		
	//��Ϸ����
	public static void Gameroom() throws Exception{		   
		System.out.println("------��ӭ����˫ɫ����Ϸ����--------");
		System.out.println("1.��ʽ��ѡ����Ͷע");
		System.out.println("2.��ʽ��ѡ����Ͷע");
		System.out.println("3.��ʽ������ѡ����Ͷע");
		System.out.println("4.��ʽ������ѡ����Ͷע");
		System.out.println("5.ȫ��ʽ��ѡ����Ͷע");
		System.out.println("6.˫ɫ������ѡͶע");
		System.out.println("7.���԰浥ʽ��ѡ�淨");
		System.out.println("8.���԰渴ʽ��ѡ�淨");
		System.out.print("��ѡ�������淨��");
        int x=src.nextInt();
		switch(x){
		case 1: Game.bet1(); break;
		case 2: Game.bet2(); break;
		case 3: Game.bet3(); break;
		case 4: Game.bet4(); break;
		case 5: Game.bet5(); break;
		case 6: Game.bet55(); break;
		case 7: Game.bet6(); break;
		case 8: Game.bet7(); break;


		}
	}

	public static void Consume() throws Exception{		//�鿴���Ѽ�¼
		Testcs.consum();
	}
	public static void Happy() throws Exception{		//�鿴�н���¼
		
		Testwpruser.priorwpruser(username);
	}
	public static void Prior() throws Exception{		//�鿴�����н�����
		Testwpr1.priorwpr();
	}
	
	
	
		
		
	

}
