package com.neusoft.test0712;

public class Test5 {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
//		do{
//			�Ƚ���һ�� �ڽ����ж�
//		}while()
		
		int a = 1;
//		do{
//			System.out.println(a);
//
//		}while(a<100);
		
//		while(a<100){
//			System.out.println(a);
//			a++;
//		}
		
//		1-100 do  while
		int s = 0;
		do{
			s = s+a;
			a++;
		}while(a<=100);
		System.out.println(s);
		
//		ʹ��whileѭ��
		int i=1;
		int sum=0;
		while(i<=100){ //�ж������Ƿ�ѭ��
			sum=sum+i;
			i++;//ִ������
		}
		System.out.println(sum);
		
//		for(��ʼ���������ж�������){}
		int p=0;
//		for(int t=1;t<=100;t++){
//			p=p+t;//�����߼�
//		}
		for(int t=1;t<=99;t=t+2,t++){
			p=p+t;//�����߼�
			
		}
		System.out.println(p);
		
		
		
	}
}
