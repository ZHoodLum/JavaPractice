package com.neusoft.test0724;

import java.util.Scanner;

public class Testring {

	int a=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//3.дһ��������ʹ��linkedlist  ջʵ��  ���� ����
		    //4.дһ��������ʹ������ʵ�ֻ��ζ��� ���ǹ��� ���洢10������
		    //5.��Ԫ�� 23��7��56��7��4��32��36��78��5��98 �ŵ����ϵ��а���С�������
//		               ����������ѡ�����ʱʹ�õ��������������
//		Random r=new Random();
//		int y=r.nextInt(6)+1;
//		int x=r.nextInt(8)+1;
//		System.out.println("y="+y+";x="+x);
		Testring t=new Testring();
	   int[] a=new int[10];
		int[] b= t.shuru();
		for(int n:b){
			System.out.println(n);
		}
		t.ring(a,b);
		for(int n:a){
			System.out.print(n+",");
		}
	}
	
	
	public  int[] shuru(){//���� ��       //�����������ݵ�   int����
		Scanner sc=new Scanner(System.in);
		System.out.println("������������,�ָ�");
		String s=sc.next();
		String[] sarry=s.split(",");//11��23��23��34��54----��{"11","23","23","34","54"}
		
		int[]   sintarray=new int[sarry.length]; //{0,0,0,0,0,0,0,0,0,0,0}
		
		for(int i=0;i<sarry.length;i++){   ////{"11","23","23","34","54"}
			
			sintarray[i]=Integer.parseInt(sarry[i]);
			
		}
		
		return sintarray;
	}
	
	public  void ring(int[] a,int[] b){// a[]��Բ��    ���װ10��    ,   b[]װ�����ǵ�ģ�����������
		
		for(int i=0;i<b.length;i++){
			this.a=i%10;
			a[this.a]=b[i];
			
		}
		
		
	}
}
