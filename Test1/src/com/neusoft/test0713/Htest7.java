package com.neusoft.test0713;


import java.util.Scanner;

public class Htest7{
	
	//计算个人所得税,3500,5000,3500与5000税后金额差,输入税前工资 显示税后工资  显示交了多少税

   /*
    * 税前工资 4,500.00
    * 五险一金 300.00
    * 起征点 3,500.00
    * 
    * 起征点：指税法规定对征税对象开始征税的起点数额。征税对象的数额达到起征点的就全部数额征税，未达到起征点的不征税。
    * 
    * 应纳税所得额 = 税前工资 －五险一金 － 起征点
	* = 4,500.00 －300.00 － 3,500.00
	* = 700.00
	* 
	* 个人所得税是采用速算扣除数法计算超额累进税率的所得税时的计税公式是：
	* 
	* 速算扣除数是指用快捷方法计算税款时，可以扣除的数额。个人所得税的计算，可以将应纳税所得额分成不同级距和相应的税率来计算。
	* 如扣除3500元后的应纳税所得额在1500元以内的，按3%税率计算，1500－4500元之间的部分（即3000元），按10%的税率计算。
	* 
	* 应纳税额 = 应纳税所得额 × 税率 － 速算扣除数
	* = 700.00 × 3% － 0.00
	* = 21.00

	* 税后工资 = 税前工资 － 五险一金 － 应纳个税
	* = 4,500.00 － 300.00 － 21.00
	* = 4,179.00
    */
	
	public static void main(String[] args) {
		sum();
		
	}
	//求差
	private static void sum(){
		double s1 = 0;
		s1 = query1(s1);

		double s2 = 0;
		s2 = query2(s2);
		
		double c=0;
		
		if(s1==0){
			s1 = query1(s1);
		}
//		else if(s2==0){
//			s2 = query1(s2);
//		}
		else{
			if(s1>s2){
				c = s1-s2;
				System.out.println("税后工资"+s1+"与"+"税后工资"+s2+"两者之间的差为："+c);
			}
			else{
				c = s2-s1;
				System.out.println("税后工资"+s1+"与"+"税后工资"+s2+"两者之间的差为："+c);
			}
			
		}
		
		if(s2==0){
			s2 = query1(s2);
		}
		else{
			if(s1>s2){
				c = s1-s2;
				System.out.println("税后工资"+s1+"与"+"税后工资"+s2+"两者之间的差为："+c);
			}
			else{
				c = s2-s1;
				System.out.println("税后工资"+s1+"与"+"税后工资"+s2+"两者之间的差为："+c);
			}
			
		}
		System.out.println();
		
		
	}
	//3500元
	protected static double query1(double s1){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入税前金额(此时起征点为3500):");
		double money = sc.nextDouble();
		if(money>=3500){
			System.out.println("请输入五险一金金额:");
			double w = sc.nextDouble();
	//		System.out.println("请输入起征点金额:");
	//		double q = sc.nextDouble();
	//		应纳税所得额 = 税前工资 －五险一金 － 起征点
			double y = money-w-3500;
			System.out.println("应纳税所得金额：  "+ y);
			
	//		速算扣除数 ：0
	//		应纳税额 = 应纳税所得额 × 税率 － 速算扣除数
			double ys = 0;//应纳税金额
			if(y>0&&y<=1500){
				
				ys = y*0.03-0.00;
				System.out.println("应纳税金额:"+ ys);
			}
			else if(y>1500&&y<=4500){
				
				ys = y*0.1-105.0;
				System.out.println("应纳税金额:"+ ys);
			}
			else if(y>4500&&y<=9000){
				
				ys = y*0.20-555.0;
				System.out.println("应纳税金额:"+ ys);
			}
			else if(y>9000&&y<=35000){
				
				ys = y*0.25-1005.0;
				System.out.println("应纳税金额:"+ ys);
			}
			else if(y>35000&&y<=55000){
				
				ys = y*0.30-2755.0;
				System.out.println("应纳税金额:"+ ys);
			}
			else if(y>55000&&y<=8000000){
				
				ys = y*0.35-5505.0;
				System.out.println("应纳税金额:"+ ys);
			}
			else if(y>8000000){
				ys = y*0.45-13505.0;
				System.out.println("应纳税金额:"+ ys);
			}
	//		税后工资 = 税前工资 － 五险一金 － 应纳个税
			s1 = money-w-ys;
			System.out.println("税后工资"+s1);
			System.out.println();
		}else{
			System.out.println("家里有矿啊!这点钱还交税？？？？");
		}
			return s1;
	
	}
	
	//5000
	protected static double query2(double s2){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入税前金额(此时起征点为5000):");
		double money = sc.nextDouble();
		if(money>=5000){
			System.out.println("请输入五险一金金额:");
			double w = sc.nextDouble();
	//		System.out.println("请输入起征点金额:");
	//		double q = sc.nextDouble();
	//		应纳税所得额 = 税前工资 －五险一金 － 起征点
			double y = money-w-5000;
			System.out.println("应纳税所得金额：  "+ y);
			
	//		速算扣除数 ：0
	//		应纳税额 = 应纳税所得额 × 税率 － 速算扣除数
			double ys = 0;//应纳税金额
			if(y>0&&y<=1500){
				
				ys = y*0.03-0.00;
				System.out.println("应纳税金额:"+ ys);
			}
			else if(y>1500&&y<=4500){
				
				ys = y*0.1-105.0;
				System.out.println("应纳税金额:"+ ys);
			}
			else if(y>4500&&y<=9000){
				
				ys = y*0.20-555.0;
				System.out.println("应纳税金额:"+ ys);
			}
			else if(y>9000&&y<=35000){
				
				ys = y*0.25-1005.0;
				System.out.println("应纳税金额:"+ ys);
			}
			else if(y>35000&&y<=55000){
				
				ys = y*0.30-2755.0;
				System.out.println("应纳税金额:"+ ys);
			}
			else if(y>55000&&y<=8000000){
				
				ys = y*0.35-5505.0;
				System.out.println("应纳税金额:"+ ys);
			}
			else if(y>8000000){
				ys = y*0.45-13505.0;
				System.out.println("应纳税金额:"+ ys);
			}
	//		税后工资 = 税前工资 － 五险一金 － 应纳个税
			s2 = money-w-ys;
			System.out.println("税后工资"+s2);
		}else{
			System.out.println("家里有矿啊!这点钱还交税？？？？");
		}
		System.out.println();
		System.out.println();
		return s2;
	
	}
	
}
