package com.neusoft.test0712;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("++++++++++��+��+ϵ+ͳ++++++++++");
        while(true){
            System.out.println("1���齱       2���˳�");
            System.out.println("��ѡ��");
            //����ɨ���� ���ղ���
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            //����֧�ж��Ƿ��ڷ�Χ��
            if(num==1){
                int r=(int)(Math.random()*11);
                System.out.println("������������Ϊ��"+r);
                if(r==10){
                    System.out.println("һ�Ƚ������嵺������");
                }else if(r>=8 && r<10){
                    System.out.println("���Ƚ����ٻ�ʦϿ��һ����");
                }else if(r>=6 && r<8){
                    System.out.println("���Ƚ���**��һ����");
                }else{
                    System.out.println("���뽱�����ڲ���");
                }
            }else if(num==2){
                System.out.println("ϵͳ���˳���");
                return;
            }else{
                System.out.println("������Ĳ���ȷ�����������룡");
            }
        }
	}

}
