package com.neusoft.test0713;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//��С�����������
		int[] a = {23,13,45,6,78,12,4,1};
		//ð������

		//ѭ��a.length��
		//ѭ����ʼʱ��
		long start = System.currentTimeMillis();
		//ѭ������ ���Կ���ʱ��
		for(int k=0;k<1000;k++){
		for(int j=0;j<a.length;j++){
			
			//1\���ֵ������ȡ����13 23 6 45 12 4 1 78
			//1\�ڶ��������ȡ����13 6 23 12 4 1 45 78
			//ÿ��������бȽ�
//			for(int i=0;i<a.length-1;i++) ��j�벻��j����  ��Ҫ�Ż�
			for(int i=0;i<a.length-1-j;i++){
				if(a[i]>a[i+1]){
					int temp = 0;
					//a[i]  a[i+1] ����λ�û���
					temp =a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
				}
			}	
		}}
		//ѭ������ʱ��
		long end = System.currentTimeMillis();
		System.out.println("����ʱ��;"+(end-start));
		//���
		for(int n:a){
			System.out.print(n+"  ");
		}
		
		
	}

}
