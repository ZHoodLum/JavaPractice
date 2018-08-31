package com.neusoft.test1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Game {
	static int[] user = new int[7];
	static Scanner src = new Scanner(System.in);
	
	public static int[] bet1() throws Exception{
		Random  rd = new Random();
		System.out.println("\n%%投注机摇奖中....");
		System.out.println("\n为您选择号码（最後一個號為藍球）");
		for(int i=0;i<user.length-1;i++){	//红球号
			int  a=rd.nextInt(33)+1;	//a为产生的随机数
			if(i==0){
				user[i]=a;	//i=0时直接存
			}
			else{ 				//i>0时，实现6个红球号，每个不相同
				for(int j=i;j>0;j--){						//i=3时，要存n[3].j=3,比较a与n[3-3]？相同，刷新a值，j=i+1=4,然后j--,j=3,再次比较a与n[3-3]
					if(a==user[i-j])						//如果a与n[3-3]不同，j--，j=2,比较a与n[3-2]？相同，刷新a值，j=i+1=4，,然后j--,j=3,再次比较a与n[3-3]
					{ //a与前面的数相同了，所以需要重新刷新一个a值	        //如果a与n[3-2]不同,j--,j=1,比较a与n[3-1]？
						a=rd.nextInt(33)+1;					//如果a与n[3-1]不同,j--,j=0,不符合，跳出，a值存到n[3]
						j=i+1;	//重置j的值，因为下一轮j会减1
					}
				}
				user[i]=a;	
			}
		}
		user[user.length-1]=rd.nextInt(16)+1;	 //蓝球号
		for(int k:user){
			System.out.print(" "+k);
		}
		
		Ward.ward(user);  //兑奖
		return user;
	}
	
	public static int[] bet2() throws Exception{
		System.out.println("请输入您要投注号码（最後一個號為藍球）");
		for(int i= 0;i<user.length;i++){
			user[i] = src.nextInt();
		}
		Ward.ward(user);  //兑奖
		return user;
	}
	
	public static int[] bet3() throws Exception{
		
		System.out.println("\n**玩法介绍：\n\t从红色球号码中选择7-16个号码,"
		 +"从蓝色球号码中选择1个号码，组合为多注单式投注号码的投注。\n");
		System.out.print("红球数：");
		int s=src.nextInt();
		if(s<7||s>16){
			System.out.println("本玩法只支持7-16个红球！");
		}else{
			System.out.print("请输入您选择的球号（最後一個號為藍球）");
			int[] ballnum=new int[s+1]; 
			for(int i= 0;i<ballnum.length;i++){
				ballnum[i] = src.nextInt();
			}
			int zl=1;
			for(int t=s;t>s-6;t--){
				zl=zl*t;
			}	
			zl=zl/(6*5*4*3*2);  //共生成多少注
			System.out.println("\n共"+zl+"注");
			int[][] nums=new int[zl][7];
			for(int i=0;i<nums.length;i++){
				for(int j=0,k=0;k<ballnum.length-1&&j<ballnum.length-1;j++,k++){	//第一注 2 3 4 5 6 7    
					if(i==k){
						k++;
						nums[i][j]=ballnum[k];
					}else{
						nums[i][j]=ballnum[k];
					}
				}
				nums[i][6]=ballnum[ballnum.length-1];
			}
			for(int[] a:nums){
				for(int k:a){
					System.out.print(k+",");
				}
				System.out.println();
			}
			Comp.ward(nums,s);  //兑奖
		}
		
		return user;
	}
	
	public static int[] bet4(){
		System.out.println("\n此玩法正在加速升级中，敬请期待！");
		return user;
	}
	
	public static int[] bet5(){
		System.out.println("\n此玩法正在加速升级中，敬请期待！");
		return user;
	}
	public static int[] bet55(){
		System.out.println("\n**玩法介绍：\n\t红色球选择（1~5个）号码作为每注都有的号码作为胆码，\n"
				 +"再选取除胆码以外的号码作为拖码（胆码和拖码之和最多只能20个，但至少七个），\n"
				 +"从蓝色球号码中选择1个号码，由胆码和拖码以及蓝色球号码组合成多注投注。\n");
		return user;
	}
	
	public static int[] bet6() throws Exception{
		System.out.print("\n内定号：");
		Ward22.Ernie();
		System.out.println("\n请输入您要投注号码（最後一個號為藍球）");
		for(int i= 0;i<user.length;i++){
			user[i] = src.nextInt();
		}
		Ward22.ward(user);  //兑奖
		return user;
	}
	public static int[] bet7() throws Exception{
		System.out.print("\n内定号：");
		Comp22.Ernie();
		System.out.println("\n**玩法介绍：\n\t从红色球号码中选择7-16个号码,"
				 +"从蓝色球号码中选择1个号码，组合为多注单式投注号码的投注。\n");
				System.out.print("红球数：");
				int s=src.nextInt();
				if(s<7||s>16){
					System.out.println("本玩法只支持7-16个红球！");
				}else{
					System.out.print("请输入您选择的球号（最後一個號為藍球）");
					int[] ballnum=new int[s+1]; 
					for(int i= 0;i<ballnum.length;i++){
						ballnum[i] = src.nextInt();
					}
					int zl=1;
					for(int t=s;t>s-6;t--){
						zl=zl*t;
					}	
					zl=zl/(6*5*4*3*2);  //共生成多少注
					System.out.println("\n共"+zl+"注");
					int[][] nums=new int[zl][7];
					for(int i=0;i<nums.length;i++){
						for(int j=0,k=0;k<ballnum.length-1&&j<nums[0].length-1;j++,k++){	//第一注 2 3 4 5 6 7    
							if(i==k){
								k++;
								nums[i][j]=ballnum[k];
							}else{
								nums[i][j]=ballnum[k];
							}
						}
						nums[i][6]=ballnum[ballnum.length-1];
					}
					for(int[] a:nums){
						for(int k:a){
							System.out.print(k+",");
						}
						System.out.println();
					}
					Comp22.ward(nums,s);  //兑奖

				}
		    return user;
	}

}
