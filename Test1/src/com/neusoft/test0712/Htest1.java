package com.neusoft.test0712;

import java.util.Scanner;

public class Htest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("*****东软跨境电商交易平台*******");
		while(true){
			System.out.println("*                           *");
			System.out.println("*     1、制造商质量管理               *");
			System.out.println("*     2、销售商品品牌管理            *");
			System.out.println("*     3、商品类型管理                   *");
			System.out.println("*     4、商品详细信息管理            *");
			System.out.println("*     0、退出程序                          *");
			System.out.println("*                           *");
			System.out.println("*****************************");
		
			System.out.println("请输入有效数字选择操作：");
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			
			if(n==0){
				System.out.println("欢迎使用本软件，再见！");
			}break;
		}
	}

}
