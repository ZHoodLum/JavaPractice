package com.neusoft.test1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ward {    //单机版兑奖
	
	static int[] number =new int[7]; 
	static Double money;
	static int wlevel=10;
	
	public static void ward(int[] user) throws Exception{
		
		int a=Money.moneyT();	//投注倍数及余额
		if(a==0){	//a==0说明余额充足
			System.out.println("\n本期彩票即将开奖.....\n");
			Ernie();
			print();
			//对奖机
			int level=0;//level表示几等奖
			int equals = 0;// equals表示相等的球的个数
			for (int j = 0; j < 6; j++) {		//0 1 2 3 4 5
				for (int i = 0; i <6; i++) {	//0 1 2 3 4 5 
					if (number[j] == user[i]) {
//						temp=number[j];
//						number[j]=-1;		//如果這個號相等，把這個數拿掉，以防之後用戶的球號還有與他相同的				
//						user[i]=-1;
						equals += 1;
					}
				}
			}
			if ((equals == 6) && (number[6] == user[6])) 	 //6+1
				level = 1;
			else if ((equals == 6) && (number[6] != user[6]))	//6+0
				level = 2;
			else if((equals==5)&& (number[6] == user[6]))		//5+1
				level = 3;
			else if(((equals==5)&& (number[6] != user[6]))		//5+0,4+1
					||((equals==4)&& (number[6] == user[6])))
				level = 4;
			else if(((equals==4)&& (number[6] != user[6]))		//4+0,3+1
					||((equals==3)&& (number[6] == user[6])))
				level = 5;
			else if (number[6] == user[6])
				level = 6;
			
			switch(level){
			case 1: Money.money1();wlevel=1;break;
			case 2: Money.money2();wlevel=2;break;
			case 3: Money.money3();wlevel=3;break;
			case 4: Money.money4();wlevel=4;break;
			case 5: Money.money5();wlevel=5;break;
			case 6: Money.money6();wlevel=6;break;
			default:System.out.println("\n\n很抱歉，本期您沒有中獎！\n");
			}
		
			if(wlevel>6){
				Money.insertw1(user);  //没人中奖
			}else{
				Money.insertw0(user,wlevel);//有人中奖
			}
		}
	}
	
	 //摇奖机
	public static void Ernie() throws Exception{		  
		Random rd = new Random();
		System.out.print("本期的中奖号码（最後一號藍球）：");
		for(int i=0;i<number.length-1;i++){
			int  a=rd.nextInt(33)+1;	//a为产生的随机数
			if(i==0){
				number[i]=a;	//i=0时直接存
			}
			else{ 				//i>0时，实现6个红球号，每个不相同
				for(int j=i;j>0;j--){						//i=3时，要存n[3].j=3,比较a与n[3-3]？相同，刷新a值，j=i+1=4,然后j--,j=3,再次比较a与n[3-3]
					if(a==number[i-j])						//如果a与n[3-3]不同，j--，j=2,比较a与n[3-2]？相同，刷新a值，j=i+1=4，,然后j--,j=3,再次比较a与n[3-3]
					{ //a与前面的数相同了，所以需要重新刷新一个a值	        //如果a与n[3-2]不同,j--,j=1,比较a与n[3-1]？
						a=rd.nextInt(33)+1;					//如果a与n[3-1]不同,j--,j=0,不符合，跳出，a值存到n[3]
						j=i+1;	//重置j的值，因为下一轮j会减1
					}
				}
			number[i]=a;	
			}
		}
		number[number.length-1]=rd.nextInt(16)+1;		
	}
	
	public static void print() throws Exception{
		for(int k:number){
			System.out.print(" "+k);
		}
	}


}
