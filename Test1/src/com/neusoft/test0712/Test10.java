package com.neusoft.test0712;

public class Test10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*
 * 	a[] ����ڼ�λ����  [] �����һ�������еĵڼ�λ��  �൱��x,y��
 */
		int[][] a = { {1,2,3},{2,3,6} };
		System.out.println(a[0][0]);
		
		System.out.println("------------��ά����forѭ���ı���----------");
//		for(int i = 0;i<a.length;i++){//ѭ�������������
//	        for(int j = 0;j<a[i].length;j++){//ѭ�����������
//	            System.out.print((a[i][j])+",");//���������е�ÿһ��
//	        }
//	    }

		System.out.println("whileѭ������");
/*		int i=0;
		int n=0;
		while(n<a.length){
			while(i<a[n].length){
				System.out.print(a[n][i]+",");
				i++;
			}
			i=0;
			n++;
			System.out.println();
		}
		
*/		
		
		System.out.println("while for���ѭ������");
/*		int i=0;
		for(int n=0;n<a.length;n++){
			while(i<a[n].length){
				System.out.print(a[n][i]+",");
				i++;
			}
			i=0;
			System.out.println();
		}
		
*/		
		System.out.println("foreach���ѭ������");
//		for(int[] b:a){
//			for(int n:b){
//				System.out.println(n+",");
//			}
//		}
		
		
	}

}
