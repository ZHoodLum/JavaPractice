package com.neusoft.test0713;


import java.util.Scanner;

public class Htest7{
	
	//�����������˰,3500,5000,3500��5000˰�����,����˰ǰ���� ��ʾ˰����  ��ʾ���˶���˰

   /*
    * ˰ǰ���� 4,500.00
    * ����һ�� 300.00
    * ������ 3,500.00
    * 
    * �����㣺ָ˰���涨����˰����ʼ��˰����������˰���������ﵽ������ľ�ȫ��������˰��δ�ﵽ������Ĳ���˰��
    * 
    * Ӧ��˰���ö� = ˰ǰ���� ������һ�� �� ������
	* = 4,500.00 ��300.00 �� 3,500.00
	* = 700.00
	* 
	* ��������˰�ǲ�������۳��������㳬���۽�˰�ʵ�����˰ʱ�ļ�˰��ʽ�ǣ�
	* 
	* ����۳�����ָ�ÿ�ݷ�������˰��ʱ�����Կ۳��������������˰�ļ��㣬���Խ�Ӧ��˰���ö�ֳɲ�ͬ�������Ӧ��˰�������㡣
	* ��۳�3500Ԫ���Ӧ��˰���ö���1500Ԫ���ڵģ���3%˰�ʼ��㣬1500��4500Ԫ֮��Ĳ��֣���3000Ԫ������10%��˰�ʼ��㡣
	* 
	* Ӧ��˰�� = Ӧ��˰���ö� �� ˰�� �� ����۳���
	* = 700.00 �� 3% �� 0.00
	* = 21.00

	* ˰���� = ˰ǰ���� �� ����һ�� �� Ӧ�ɸ�˰
	* = 4,500.00 �� 300.00 �� 21.00
	* = 4,179.00
    */
	
	public static void main(String[] args) {
		sum();
		
	}
	//���
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
				System.out.println("˰����"+s1+"��"+"˰����"+s2+"����֮��Ĳ�Ϊ��"+c);
			}
			else{
				c = s2-s1;
				System.out.println("˰����"+s1+"��"+"˰����"+s2+"����֮��Ĳ�Ϊ��"+c);
			}
			
		}
		
		if(s2==0){
			s2 = query1(s2);
		}
		else{
			if(s1>s2){
				c = s1-s2;
				System.out.println("˰����"+s1+"��"+"˰����"+s2+"����֮��Ĳ�Ϊ��"+c);
			}
			else{
				c = s2-s1;
				System.out.println("˰����"+s1+"��"+"˰����"+s2+"����֮��Ĳ�Ϊ��"+c);
			}
			
		}
		System.out.println();
		
		
	}
	//3500Ԫ
	protected static double query1(double s1){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������˰ǰ���(��ʱ������Ϊ3500):");
		double money = sc.nextDouble();
		if(money>=3500){
			System.out.println("����������һ����:");
			double w = sc.nextDouble();
	//		System.out.println("��������������:");
	//		double q = sc.nextDouble();
	//		Ӧ��˰���ö� = ˰ǰ���� ������һ�� �� ������
			double y = money-w-3500;
			System.out.println("Ӧ��˰���ý�  "+ y);
			
	//		����۳��� ��0
	//		Ӧ��˰�� = Ӧ��˰���ö� �� ˰�� �� ����۳���
			double ys = 0;//Ӧ��˰���
			if(y>0&&y<=1500){
				
				ys = y*0.03-0.00;
				System.out.println("Ӧ��˰���:"+ ys);
			}
			else if(y>1500&&y<=4500){
				
				ys = y*0.1-105.0;
				System.out.println("Ӧ��˰���:"+ ys);
			}
			else if(y>4500&&y<=9000){
				
				ys = y*0.20-555.0;
				System.out.println("Ӧ��˰���:"+ ys);
			}
			else if(y>9000&&y<=35000){
				
				ys = y*0.25-1005.0;
				System.out.println("Ӧ��˰���:"+ ys);
			}
			else if(y>35000&&y<=55000){
				
				ys = y*0.30-2755.0;
				System.out.println("Ӧ��˰���:"+ ys);
			}
			else if(y>55000&&y<=8000000){
				
				ys = y*0.35-5505.0;
				System.out.println("Ӧ��˰���:"+ ys);
			}
			else if(y>8000000){
				ys = y*0.45-13505.0;
				System.out.println("Ӧ��˰���:"+ ys);
			}
	//		˰���� = ˰ǰ���� �� ����һ�� �� Ӧ�ɸ�˰
			s1 = money-w-ys;
			System.out.println("˰����"+s1);
			System.out.println();
		}else{
			System.out.println("�����п�!���Ǯ����˰��������");
		}
			return s1;
	
	}
	
	//5000
	protected static double query2(double s2){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������˰ǰ���(��ʱ������Ϊ5000):");
		double money = sc.nextDouble();
		if(money>=5000){
			System.out.println("����������һ����:");
			double w = sc.nextDouble();
	//		System.out.println("��������������:");
	//		double q = sc.nextDouble();
	//		Ӧ��˰���ö� = ˰ǰ���� ������һ�� �� ������
			double y = money-w-5000;
			System.out.println("Ӧ��˰���ý�  "+ y);
			
	//		����۳��� ��0
	//		Ӧ��˰�� = Ӧ��˰���ö� �� ˰�� �� ����۳���
			double ys = 0;//Ӧ��˰���
			if(y>0&&y<=1500){
				
				ys = y*0.03-0.00;
				System.out.println("Ӧ��˰���:"+ ys);
			}
			else if(y>1500&&y<=4500){
				
				ys = y*0.1-105.0;
				System.out.println("Ӧ��˰���:"+ ys);
			}
			else if(y>4500&&y<=9000){
				
				ys = y*0.20-555.0;
				System.out.println("Ӧ��˰���:"+ ys);
			}
			else if(y>9000&&y<=35000){
				
				ys = y*0.25-1005.0;
				System.out.println("Ӧ��˰���:"+ ys);
			}
			else if(y>35000&&y<=55000){
				
				ys = y*0.30-2755.0;
				System.out.println("Ӧ��˰���:"+ ys);
			}
			else if(y>55000&&y<=8000000){
				
				ys = y*0.35-5505.0;
				System.out.println("Ӧ��˰���:"+ ys);
			}
			else if(y>8000000){
				ys = y*0.45-13505.0;
				System.out.println("Ӧ��˰���:"+ ys);
			}
	//		˰���� = ˰ǰ���� �� ����һ�� �� Ӧ�ɸ�˰
			s2 = money-w-ys;
			System.out.println("˰����"+s2);
		}else{
			System.out.println("�����п�!���Ǯ����˰��������");
		}
		System.out.println();
		System.out.println();
		return s2;
	
	}
	
}
