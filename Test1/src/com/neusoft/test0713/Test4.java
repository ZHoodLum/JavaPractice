package com.neusoft.test0713;

public class Test4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//��С�����������
		int[] a = {23,13,45,6,78,12,4,1};
		//ð������
		//ѭ��a.length��
		int j=0;
		int i=0;
		while(j<a.length){
//			for(int i=0;i<a.length-1-j;i++){
//				if(a[i]<a[i+1]){
//					int temp = 0;
//					//a[i]  a[i+1] ����λ�û���
//					temp =a[i+1];
//					a[i+1]=a[i];
//					a[i]=temp;
//				}
//			}
			while(i<a.length-1-j){
				if(a[i]<a[i+1]){
					int temp = 0;
					//a[i]  a[i+1] ����λ�û���
					temp =a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
				}
				i++;
			}
			j++;
		}
		//���
		for(int n:a){
			System.out.print(n+"  ");
		}
		
		
	}
}
