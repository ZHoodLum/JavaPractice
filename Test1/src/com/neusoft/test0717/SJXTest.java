package com.neusoft.test0717;

import java.util.Scanner;

public class SJXTest {
	public static void main(String[] args) {
		
		SJX s = new SJX();
		Scanner sc = new Scanner(System.in);
		System.out.println("�����������ε�A�߳���Ϊ��");
		s.setA(sc.nextInt());
		
		if(s.getA()<=0){
			System.out.println("����������������룺");
			s.setA(sc.nextInt());
		}else{
			
		}
		
		System.out.println("�����������ε�B�߳���Ϊ��");
		s.setB(sc.nextInt());
		
		if(s.getB()<=0){
			System.out.println("����������������룺");
			s.setB(sc.nextInt());
		}else{
			
		}
		
		System.out.println("�����������ε�C�߳���Ϊ��");
		s.setC(sc.nextInt());
		
		if(s.getC()<=0){
			System.out.println("����������������룺");
			s.setC(sc.nextInt());
		}else{
			
		}

		if(((s.getA() + s.getB()) > s.getC()) && ((s.getA() + s.getC()) > s.getB())&&((s.getB() + s.getC()) > s.getA()))
		{	
			if((s.getA()==s.getB()) || (s.getB()==s.getC()) || (s.getA()==s.getC())){
				if((s.getA()==s.getB()) && (s.getB()==s.getC()) && (s.getA()==s.getC())){
					System.out.println("����һ���ȱ�������");
					System.out.println("�������ε�A�߳���Ϊ��"+s.getA());
					System.out.println("�������ε�A�߳���Ϊ��"+s.getB());
					System.out.println("�������ε�A�߳���Ϊ��"+s.getC());
				}else{
					System.out.println("����һ������������");
					System.out.println("�������ε�A�߳���Ϊ��"+s.getA());
					System.out.println("�������ε�A�߳���Ϊ��"+s.getB());
					System.out.println("�������ε�A�߳���Ϊ��"+s.getC());
				}
			}
			else{
				System.out.println("����һ�����ȱ�������");
				System.out.println("�������ε�A�߳���Ϊ��"+s.getA());
				System.out.println("�������ε�A�߳���Ϊ��"+s.getB());
				System.out.println("�������ε�A�߳���Ϊ��"+s.getC());
			}
		}
		else{
			System.out.println("�����������α߳��������п�����");
		}
		
	}
	
}
