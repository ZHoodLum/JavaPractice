package com.neusoft.test1;

import java.util.Random;
import java.util.Scanner;

public class twocolorball {

	public static void main(String[] args) {
		
		/*˫ɫ����Ϸ����
		 ÿעͶע������6������ź�1���������ɡ�
		��������1--33��ѡ����ɫ������1--16��ѡ��
		6��������룬ÿ������ͬ
		һ�Ƚ���7�����������6����ɫ������1����ɫ����룩����ɫ�����˳���ޣ���ͬ��
		���Ƚ���6����ɫ����������
		���Ƚ���5����ɫ������1����ɫ����������
		�ĵȽ���5����ɫ������4����ɫ������1����ɫ����������
		��Ƚ���4����ɫ������3����ɫ������1����ɫ����������
		���Ƚ���1����ɫ�������������޺�ɫ�����������ɣ���

		*/
		
		while(true){	
			//ҡ����������������롣number����0-5�����6������
			int[] number =new int[7]; 
			Random rd = new Random();
			System.out.print("���Ǳ����εĿ����ţ�����һ��̖���{�򣩣�");
			for(int i=0;i<number.length-1;i++){
				int  a=rd.nextInt(33)+1;	//aΪ�����������
				if(i==0){
					number[i]=a;	//i=0ʱֱ�Ӵ�
				}
				else{ 				//i>0ʱ��ʵ��6������ţ�ÿ������ͬ
					for(int j=i;j>0;j--){						//i=3ʱ��Ҫ��n[3].j=3,�Ƚ�a��n[3-3]����ͬ��ˢ��aֵ��j=i+1=4,Ȼ��j--,j=3,�ٴαȽ�a��n[3-3]
						if(a==number[i-j])						//���a��n[3-3]��ͬ��j--��j=2,�Ƚ�a��n[3-2]����ͬ��ˢ��aֵ��j=i+1=4��,Ȼ��j--,j=3,�ٴαȽ�a��n[3-3]
						{ //a��ǰ�������ͬ�ˣ�������Ҫ����ˢ��һ��aֵ	        //���a��n[3-2]��ͬ,j--,j=1,�Ƚ�a��n[3-1]��
							a=rd.nextInt(33)+1;					//���a��n[3-1]��ͬ,j--,j=0,�����ϣ�������aֵ�浽n[3]
							j=i+1;	//����j��ֵ����Ϊ��һ��j���1
						}
					}
				number[i]=a;	
				}
			}
			number[number.length-1]=rd.nextInt(13)+1;	
			for(int k:number){
				System.out.print(" "+k);
			}
			System.out.println();
			
			//�����,user���M0-5�����6������
			System.out.println("����������Ͷע���루����һ��̖���{��");
			Scanner src = new Scanner(System.in);
			int[] user = new int[7];
			for(int i= 0;i<user.length;i++){
				user[i] = src.nextInt();
			}
			
			//�Խ���
			int level=0;//level��ʾ���Ƚ�
			int equals = 0;// equals��ʾ��ȵ���ĸ���
			for (int j = 0; j < 6; j++) {		//0 1 2 3 4 5
				for (int i = 0; i <6; i++) {	//0 1 2 3 4 5 
					if (number[j] == user[i]) {
						number[j]=-1;		//����@��̖��ȣ����@�����õ����Է�֮���Ñ�����̖߀���c����ͬ��
						user[i]=-1;
						equals += 1;
					}
				}
			}

			if ((equals == 6) && (number[6] == user[6])) 	 //6+1
				level = 1;
			else if ((equals == 6) && (number[6] != user[6]))	//6+0
				level = 2;
			else if((equals==5)&& (number[6] == user[6]))		//5+1
				level = 3;
			else if(((equals==5)&& (number[6] != user[6]))		//5+0,4+1
					||((equals==4)&& (number[6] == user[6])))
				level = 4;
			else if(((equals==4)&& (number[6] != user[6]))		//4+0,3+1
					||((equals==3)&& (number[6] == user[6])))
				level = 5;
			else if (number[6] == user[6])
				level = 6;
			
		switch(level){
		case 1: System.out.println("��ϲ��������һ�Ƚ���");break;
		case 2: System.out.println("��ϲ�������˶��Ƚ���");break;
		case 3: System.out.println("��ϲ�����������Ƚ���");break;
		case 4: System.out.println("��ϲ���������ĵȽ���");break;
		case 5: System.out.println("��ϲ����������Ƚ���");break;
		case 6: System.out.println("��ϲ�����������Ƚ���");break;
		default:System.out.println("�ܱ�Ǹ���������]���Ъ���");
		}
						
		}//while�Y��
	}
}
