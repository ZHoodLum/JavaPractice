package com.neusoft.test1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Scanner;

public class UserLogin {
	
	static String username;	//用户名
	static String password;	//密码
	static String email;	//邮箱
	static Double money;	//余额
	static boolean flg; //退出
	static Scanner src= new Scanner(System.in);
	
	//用户登录
	public static void userLogin() throws Exception{	
		flg=true;
		Connect();	//验证用户名和密码是否正确
		while(flg){	//登录成功后一直处于这个页面，直到按0退出
		System.out.println("^^^^^^^^^^^用户菜单^^^^^^^^^^^^^");
		System.out.println("1.查看信息");
		System.out.println("2.修改信息");
		System.out.println("3.余额充值");
		System.out.println("4.游戏大厅");
		System.out.println("5.查看消费记录");
		System.out.println("6.查看中奖记录");
		System.out.println("7.查看往期中奖号码");
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
		System.out.println("*****返回首页请按0*****");
		int t=src.nextInt();
		if(t==0) flg=false;
		}
	}
	     
	//用户登录验证用户名和密码是否正确
	private static void Connect() throws Exception{	
		while(true){	//一直登陆，直到登录成功跳出
		System.out.println("-----------用户登录------------");
		System.out.print("用户名：");
		username =src.next();
		System.out.print("密码：");
		password = src.next();
		
		Connection con =null;	
		con=TowColorUtil.getCon();
		PreparedStatement pstate =con.prepareStatement("select username,password,grantuse from tcbi where username ='"+username+"' and password = '"+password+"' ");
		ResultSet rs = pstate.executeQuery();
		if(rs.next()){
			if(rs.getInt("grantuse")==1){
				System.out.println("\n亲爱的"+username+"用户，欢迎您的登录！\n");
				break;
			}else{
				System.out.println("您已禁止登录，请与管理员联系！\n");
			}
		}else{
			System.out.println("\n用户名或密码错误！\n");
		}
		TowColorUtil.closeQuery(rs, con, pstate);
		}	
	}
	
	//查看用户信息
	private static void Look() throws Exception{		
		Connection con =null;	
		con=TowColorUtil.getCon();
		PreparedStatement pstate =con.prepareStatement("select username,password,email from tcbi where username ='"+username+"' and password = '"+password+"' ");
		ResultSet rs = pstate.executeQuery();	
		if(rs.next()){
			System.out.println("用户名："+rs.getString("username")+"  密码："+rs.getString("password")+"  邮箱："+rs.getString("email"));
		}else{
			System.out.println("用户不存在！\n");
		}
		TowColorUtil.closeQuery(rs, con, pstate);
	}
	
	//修改用户信息
	public static void Update() throws Exception{			
		String pname=username;
		System.out.println("----------修改基本信息------------");
		System.out.print("用户名：");
		username=src.next();
		System.out.println("密码：");
		password=src.next();
		System.out.println("邮箱：");
		email=src.next();
	
		Connection con =null;	
		con=TowColorUtil.getCon();
		PreparedStatement pstate =con.prepareStatement("select username,email from tcbi where username ='"+username+"' or email = '"+email+"' ");
		ResultSet rs = pstate.executeQuery();
		if(rs.next()){
			System.out.println("\n用户名或邮箱已存在！\n");
		}else{		
			Statement state = con.createStatement();
			state.executeUpdate("update tcbi set username ='"+username+"' , password = '"+password+"' , email =  '"+email+"'  where username= '"+pname+"' ");
			con.commit(); 
			System.out.println("\n修改成功！\n");
			state.close();
		}
		TowColorUtil.closeQuery(rs, con, pstate);
	}
	
	//余额充值
	public static void Money() throws Exception{    
		Connection con =null;	
		con=TowColorUtil.getCon();
		PreparedStatement pstate =con.prepareStatement("select money from tcbi where username ='"+username+"' ");
		ResultSet rs = pstate.executeQuery();
		if(rs.next()){
			money=rs.getDouble("money");
			DecimalFormat df=new DecimalFormat("###,###,##0.00");
			String value=df.format(money);
			System.out.println("您的余额为:"+value);
		}
		System.out.println("是否充值 ：（按1确认）");
		int qr=src.nextInt();
		if(qr==1){
			System.out.println("充值金额：");
			Double n=src.nextDouble();
			Double m=n+money;
			Statement state = con.createStatement();
			state.executeUpdate("update tcbi set money ="+m+" where username ='"+username+"'");
			System.out.println("\n充值成功！\n");
			Consumer.Cons(0.0,0.0, n);	//更新消费表记录
			con.commit(); 
			TowColorUtil.closezz( con, state,pstate);
			rs.close();
		}	
	}
		
	//游戏大厅
	public static void Gameroom() throws Exception{		   
		System.out.println("------欢迎进入双色球游戏大厅--------");
		System.out.println("1.单式机选号码投注");
		System.out.println("2.单式自选号码投注");
		System.out.println("3.复式红球自选号码投注");
		System.out.println("4.复式蓝球自选号码投注");
		System.out.println("5.全复式自选号码投注");
		System.out.println("6.双色球胆拖自选投注");
		System.out.println("7.测试版单式自选玩法");
		System.out.println("8.测试版复式自选玩法");
		System.out.print("请选择您的玩法：");
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

	public static void Consume() throws Exception{		//查看消费记录
		Testcs.consum();
	}
	public static void Happy() throws Exception{		//查看中奖记录
		
		Testwpruser.priorwpruser(username);
	}
	public static void Prior() throws Exception{		//查看往期中奖号码
		Testwpr1.priorwpr();
	}
	
	
	
		
		
	

}
