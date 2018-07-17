package com.neusoft.test0717;

import java.util.Scanner;

public class SJXTest {
	public static void main(String[] args) {
		
		SJX s = new SJX();
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入三角形的A边长度为：");
		s.setA(sc.nextInt());
		
		if(s.getA()<=0){
			System.out.println("输入错误！请重新输入：");
			s.setA(sc.nextInt());
		}else{
			
		}
		
		System.out.println("请输入三角形的B边长度为：");
		s.setB(sc.nextInt());
		
		if(s.getB()<=0){
			System.out.println("输入错误！请重新输入：");
			s.setB(sc.nextInt());
		}else{
			
		}
		
		System.out.println("请输入三角形的C边长度为：");
		s.setC(sc.nextInt());
		
		if(s.getC()<=0){
			System.out.println("输入错误！请重新输入：");
			s.setC(sc.nextInt());
		}else{
			
		}

		if(((s.getA() + s.getB()) > s.getC()) && ((s.getA() + s.getC()) > s.getB())&&((s.getB() + s.getC()) > s.getA()))
		{	
			if((s.getA()==s.getB()) || (s.getB()==s.getC()) || (s.getA()==s.getC())){
				if((s.getA()==s.getB()) && (s.getB()==s.getC()) && (s.getA()==s.getC())){
					System.out.println("这是一个等边三角形");
					System.out.println("此三角形的A边长度为："+s.getA());
					System.out.println("此三角形的A边长度为："+s.getB());
					System.out.println("此三角形的A边长度为："+s.getC());
				}else{
					System.out.println("这是一个等腰三角形");
					System.out.println("此三角形的A边长度为："+s.getA());
					System.out.println("此三角形的A边长度为："+s.getB());
					System.out.println("此三角形的A边长度为："+s.getC());
				}
			}
			else{
				System.out.println("这是一个不等边三角形");
				System.out.println("此三角形的A边长度为："+s.getA());
				System.out.println("此三角形的A边长度为："+s.getB());
				System.out.println("此三角形的A边长度为："+s.getC());
			}
		}
		else{
			System.out.println("还输入三角形边长。家里有旷啊！");
		}
		
	}
	
}
