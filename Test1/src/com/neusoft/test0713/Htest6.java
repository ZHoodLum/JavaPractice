package com.neusoft.test0713;

import java.util.Scanner;

public class Htest6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();

//			 �����200����С����
			boolean flag = true;
			for(int i=200;;i++) {
				for(int j=2;j<i;j++) {
					if(i%j == 0) {
						//����ҵ�һ��i�ܱ�j��������֤����������
						flag = false;
						break;
					}
				}
				if(flag) {
					System.out.println("����200����С������"+i);
					break;
				}
				flag = true;
			}
			

	}

}
