package com.neusoft.test1;

import java.util.Random;

public class Comp {  //��ʽ��ҽ�


	static int[] number =new int[7]; 
	static Double money;
	static int wlevel=10;
	
	public static void test() throws Exception{
		System.out.println("\n���ڲ�Ʊ��������.....\n");
		Ernie();
		System.out.println();
	}
	
	public static void ward(int[][] user,int s) throws Exception{
		int a=Money.moneyF(s);	//����㲻��
		if(a==0){	//a==0˵��������
		test();
		for(int k=0;k<user.length;k++){  //ÿһע�ҽ�
				int level=0;//level��ʾ���Ƚ�
				int equals = 0;// equals��ʾ��ȵ���ĸ���
				for (int j = 0; j < 6; j++) {		//0 1 2 3 4 5
					for (int i = 0; i <6; i++) {	//0 1 2 3 4 5 
						if (number[j] == user[k][i]) {
//							temp=number[j];
//							number[j]=-1;		//����@��̖��ȣ����@�����õ����Է�֮���Ñ�����̖߀���c����ͬ��				
//							user[i]=-1;
							equals += 1;
						}
					}
				}
				
				if ((equals == 6) && (number[6] == user[k][6])) 	 //6+1
					level = 1;
				else if ((equals == 6) && (number[6] != user[k][6]))	//6+0
					level = 2;
				else if((equals==5)&& (number[6] == user[k][6]))		//5+1
					level = 3;
				else if(((equals==5)&& (number[6] != user[k][6]))		//5+0,4+1
						||((equals==4)&& (number[6] == user[k][6])))
					level = 4;
				else if(((equals==4)&& (number[6] != user[k][6]))		//4+0,3+1
						||((equals==3)&& (number[6] == user[k][6])))
					level = 5;
				else if (number[6] == user[k][6])
					level = 6;
				
				switch(level){
				case 1: print(user[k]);Money.money1();wlevel=1;break;
				case 2: print(user[k]);Money.money2();wlevel=2;break;
				case 3: print(user[k]);Money.money3();wlevel=3;break;
				case 4: print(user[k]);Money.money4();wlevel=4;break;
				case 5: print(user[k]);Money.money5();wlevel=5;break;
				case 6: print(user[k]);Money.money6();wlevel=6;break;
			//	default: print(user[k]);System.out.println("�ܱ�Ǹ����ע���]���Ъ�Ŷ��\n");
				}
			
				if(wlevel<=6){
					Money.insertw0(user[k],wlevel);//�����н�
				}else if(wlevel>6&&k==user.length-1){
					System.out.println("\n�ܱ�Ǹ���������]���Ъ�Ŷ��");
					Money.insertw1(user[k]);  //û���н�
				}
		}
		}
	}
	
	public static void print(int[] a){
		for(int k:a){
			System.out.print(k+",");
		}
	}
	 //ҡ����
	public static void Ernie() throws Exception{		  
		Random rd = new Random();
		System.out.print("���ڵ��н����루����һ̖�{�򣩣�");
		for(int i=0;i<number.length-1;i++){
			int  a=rd.nextInt(33)+1;	//aΪ�����������
			if(i==0){
				number[i]=a;	//i=0ʱֱ�Ӵ�
			}
			else{ 				//i>0ʱ��ʵ��6������ţ�ÿ������ͬ
				for(int j=i;j>0;j--){						//i=3ʱ��Ҫ��n[3].j=3,�Ƚ�a��n[3-3]����ͬ��ˢ��aֵ��j=i+1=4,Ȼ��j--,j=3,�ٴαȽ�a��n[3-3]
					if(a==number[i-j])						//���a��n[3-3]��ͬ��j--��j=2,�Ƚ�a��n[3-2]����ͬ��ˢ��aֵ��j=i+1=4��,Ȼ��j--,j=3,�ٴαȽ�a��n[3-3]
					{ //a��ǰ�������ͬ�ˣ�������Ҫ����ˢ��һ��aֵ	        //���a��n[3-2]��ͬ,j--,j=1,�Ƚ�a��n[3-1]��
						a=rd.nextInt(33)+1;					//���a��n[3-1]��ͬ,j--,j=0,�����ϣ�������aֵ�浽n[3]
						j=i+1;	//����j��ֵ����Ϊ��һ��j���1
					}
				}
			number[i]=a;	
			}
		}
		number[number.length-1]=rd.nextInt(16)+1;	
		for(int k:number){
			System.out.print(" "+k);
		}	
	}

}
