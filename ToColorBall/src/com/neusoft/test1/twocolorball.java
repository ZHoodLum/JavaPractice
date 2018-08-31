package com.neusoft.test1;

import java.util.Random;
import java.util.Scanner;

public class twocolorball {

	public static void main(String[] args) {
		
		/*双色球游戏规则：
		 每注投注号码由6个红球号和1个蓝球号组成。
		红球号码从1--33中选择，蓝色球号码从1--16中选择。
		6个红球号码，每个不相同
		一等奖：7个号码相符（6个红色球号码和1个蓝色球号码）（红色球号码顺序不限，下同）
		二等奖：6个红色球号码相符；
		三等奖：5个红色球号码和1个蓝色球号码相符；
		四等奖：5个红色球号码或4个红色球号码和1个蓝色球号码相符；
		五等奖：4个红色球号码或3个红色球号码和1个蓝色球号码相符；
		六等奖：1个蓝色球号码相符（有无红色球号码相符均可）。

		*/
		
		while(true){	
			//摇奖机，产生随机号码。number数组0-5存红球6存蓝球
			int[] number =new int[7]; 
			Random rd = new Random();
			System.out.print("这是本场次的开奖号（最後一個號為藍球）：");
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
			number[number.length-1]=rd.nextInt(13)+1;	
			for(int k:number){
				System.out.print(" "+k);
			}
			System.out.println();
			
			//彩民号,user數組0-5存红球6存蓝球
			System.out.println("请输入您的投注号码（最後一個號為藍球）");
			Scanner src = new Scanner(System.in);
			int[] user = new int[7];
			for(int i= 0;i<user.length;i++){
				user[i] = src.nextInt();
			}
			
			//对奖机
			int level=0;//level表示几等奖
			int equals = 0;// equals表示相等的球的个数
			for (int j = 0; j < 6; j++) {		//0 1 2 3 4 5
				for (int i = 0; i <6; i++) {	//0 1 2 3 4 5 
					if (number[j] == user[i]) {
						number[j]=-1;		//如果這個號相等，把這個數拿掉，以防之後用戶的球號還有與他相同的
						user[i]=-1;
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
		case 1: System.out.println("恭喜您，中了一等奖！");break;
		case 2: System.out.println("恭喜您，中了二等奖！");break;
		case 3: System.out.println("恭喜您，中了三等奖！");break;
		case 4: System.out.println("恭喜您，中了四等奖！");break;
		case 5: System.out.println("恭喜您，中了五等奖！");break;
		case 6: System.out.println("恭喜您，中了六等奖！");break;
		default:System.out.println("很抱歉，本期您沒有中獎！");
		}
						
		}//while結束
	}
}
