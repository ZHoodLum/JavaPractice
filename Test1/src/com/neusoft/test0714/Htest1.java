package com.neusoft.test0714;

import java.util.Random;

public class Htest1 {
	public static void main(String[] args) {
		randomball();
	}
	
	//�������� ���ڱ�������
	public static void bianliArray(int[] a){
		System.out.println("����Ϊ��");
		for(int n:a){
			System.out.print(n+" ");
		}
		System.out.println();
	}
	//�������6������  1-33    ���ظ� �������һ������ 1-16
	public static void randomball(){
		Random r = new Random();
		//��������
		int blueball = r.nextInt(16)+1;
		System.out.println(blueball);
		//���ɺ���6�� ������
		int[] redballArray = new int[6];
//		redballArray[0] = r.nextInt(33)+1;
		//����һ���� ��֮ǰ�Ľ��бȽ�
		
		for(int i=0;i<6;i++){//����ָ��
			//��һλ����
			if(i==0){
				redballArray[i] = r.nextInt(33)+1;
			}
			//�ڶ�λ����
			else if(i==1){
				int randomred = r.nextInt(33)+1;
				//�����ǰһ������ͬ  ���������
				while(true){
					if(randomred!=redballArray[i-1]){		
						randomred = r.nextInt(33)+1;
					}else{
						break;//ֱ�������
					}
					redballArray[i] = randomred;
				}
				
			}
			//����λ����
			else if(i==2){
				int randomred = r.nextInt(33)+1;
				//�����ǰһ������ͬ  ���������
				while(true){
					if(randomred!=redballArray[i-2]){		
						randomred = r.nextInt(33)+1;
					}else{
						break;//ֱ�������
					}
					redballArray[i] = randomred;
				}
				
			}
			
		}
		
		
		bianliArray(redballArray);
		
	}
}	
