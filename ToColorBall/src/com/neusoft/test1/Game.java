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
		System.out.println("\n%%Ͷע��ҡ����....");
		System.out.println("\nΪ��ѡ����루����һ��̖���{��");
		for(int i=0;i<user.length-1;i++){	//�����
			int  a=rd.nextInt(33)+1;	//aΪ�����������
			if(i==0){
				user[i]=a;	//i=0ʱֱ�Ӵ�
			}
			else{ 				//i>0ʱ��ʵ��6������ţ�ÿ������ͬ
				for(int j=i;j>0;j--){						//i=3ʱ��Ҫ��n[3].j=3,�Ƚ�a��n[3-3]����ͬ��ˢ��aֵ��j=i+1=4,Ȼ��j--,j=3,�ٴαȽ�a��n[3-3]
					if(a==user[i-j])						//���a��n[3-3]��ͬ��j--��j=2,�Ƚ�a��n[3-2]����ͬ��ˢ��aֵ��j=i+1=4��,Ȼ��j--,j=3,�ٴαȽ�a��n[3-3]
					{ //a��ǰ�������ͬ�ˣ�������Ҫ����ˢ��һ��aֵ	        //���a��n[3-2]��ͬ,j--,j=1,�Ƚ�a��n[3-1]��
						a=rd.nextInt(33)+1;					//���a��n[3-1]��ͬ,j--,j=0,�����ϣ�������aֵ�浽n[3]
						j=i+1;	//����j��ֵ����Ϊ��һ��j���1
					}
				}
				user[i]=a;	
			}
		}
		user[user.length-1]=rd.nextInt(16)+1;	 //�����
		for(int k:user){
			System.out.print(" "+k);
		}
		
		Ward.ward(user);  //�ҽ�
		return user;
	}
	
	public static int[] bet2() throws Exception{
		System.out.println("��������ҪͶע���루����һ��̖���{��");
		for(int i= 0;i<user.length;i++){
			user[i] = src.nextInt();
		}
		Ward.ward(user);  //�ҽ�
		return user;
	}
	
	public static int[] bet3() throws Exception{
		
		System.out.println("\n**�淨���ܣ�\n\t�Ӻ�ɫ�������ѡ��7-16������,"
		 +"����ɫ�������ѡ��1�����룬���Ϊ��ע��ʽͶע�����Ͷע��\n");
		System.out.print("��������");
		int s=src.nextInt();
		if(s<7||s>16){
			System.out.println("���淨ֻ֧��7-16������");
		}else{
			System.out.print("��������ѡ�����ţ�����һ��̖���{��");
			int[] ballnum=new int[s+1]; 
			for(int i= 0;i<ballnum.length;i++){
				ballnum[i] = src.nextInt();
			}
			int zl=1;
			for(int t=s;t>s-6;t--){
				zl=zl*t;
			}	
			zl=zl/(6*5*4*3*2);  //�����ɶ���ע
			System.out.println("\n��"+zl+"ע");
			int[][] nums=new int[zl][7];
			for(int i=0;i<nums.length;i++){
				for(int j=0,k=0;k<ballnum.length-1&&j<ballnum.length-1;j++,k++){	//��һע 2 3 4 5 6 7    
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
			Comp.ward(nums,s);  //�ҽ�
		}
		
		return user;
	}
	
	public static int[] bet4(){
		System.out.println("\n���淨���ڼ��������У������ڴ���");
		return user;
	}
	
	public static int[] bet5(){
		System.out.println("\n���淨���ڼ��������У������ڴ���");
		return user;
	}
	public static int[] bet55(){
		System.out.println("\n**�淨���ܣ�\n\t��ɫ��ѡ��1~5����������Ϊÿע���еĺ�����Ϊ���룬\n"
				 +"��ѡȡ����������ĺ�����Ϊ���루���������֮�����ֻ��20�����������߸�����\n"
				 +"����ɫ�������ѡ��1�����룬�ɵ���������Լ���ɫ�������ϳɶ�עͶע��\n");
		return user;
	}
	
	public static int[] bet6() throws Exception{
		System.out.print("\n�ڶ��ţ�");
		Ward22.Ernie();
		System.out.println("\n��������ҪͶע���루����һ��̖���{��");
		for(int i= 0;i<user.length;i++){
			user[i] = src.nextInt();
		}
		Ward22.ward(user);  //�ҽ�
		return user;
	}
	public static int[] bet7() throws Exception{
		System.out.print("\n�ڶ��ţ�");
		Comp22.Ernie();
		System.out.println("\n**�淨���ܣ�\n\t�Ӻ�ɫ�������ѡ��7-16������,"
				 +"����ɫ�������ѡ��1�����룬���Ϊ��ע��ʽͶע�����Ͷע��\n");
				System.out.print("��������");
				int s=src.nextInt();
				if(s<7||s>16){
					System.out.println("���淨ֻ֧��7-16������");
				}else{
					System.out.print("��������ѡ�����ţ�����һ��̖���{��");
					int[] ballnum=new int[s+1]; 
					for(int i= 0;i<ballnum.length;i++){
						ballnum[i] = src.nextInt();
					}
					int zl=1;
					for(int t=s;t>s-6;t--){
						zl=zl*t;
					}	
					zl=zl/(6*5*4*3*2);  //�����ɶ���ע
					System.out.println("\n��"+zl+"ע");
					int[][] nums=new int[zl][7];
					for(int i=0;i<nums.length;i++){
						for(int j=0,k=0;k<ballnum.length-1&&j<nums[0].length-1;j++,k++){	//��һע 2 3 4 5 6 7    
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
					Comp22.ward(nums,s);  //�ҽ�

				}
		    return user;
	}

}
