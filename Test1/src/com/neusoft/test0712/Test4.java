package com.neusoft.test0712;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("++++++++++抽+奖+系+统++++++++++");
        while(true){
            System.out.println("1：抽奖       2：退出");
            System.out.println("请选择：");
            //声明扫描器 接收参数
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            //单分支判断是否在范围内
            if(num==1){
                int r=(int)(Math.random()*11);
                System.out.println("您的幸运数字为："+r);
                if(r==10){
                    System.out.println("一等奖：巴厘岛五日游");
                }else if(r>=8 && r<10){
                    System.out.println("二等奖：召唤师峡谷一日游");
                }else if(r>=6 && r<8){
                    System.out.println("三等奖：**市一日游");
                }else{
                    System.out.println("参与奖：重在参与");
                }
            }else if(num==2){
                System.out.println("系统已退出！");
                return;
            }else{
                System.out.println("你输入的不正确，请重新输入！");
            }
        }
	}

}
