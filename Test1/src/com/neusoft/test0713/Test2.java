package com.neusoft.test0713;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//��ʼ�����˰�
		//ֱ�Ӵ�ӡ64��*   �����8ȡ��   ����
/*		for(int i=0;i<64;i++){
			if(i%8==0){
				System.out.println();
			}
			System.out.print("*");
		}
*/		
		//ʹ������
		int[] a = {
				1,1,1,1,1,1,1,1,
				1,0,0,0,0,0,0,1,
				1,0,0,0,0,0,0,1,
				1,0,0,0,0,0,0,1,
				1,0,0,0,0,0,0,1,
				1,0,0,0,0,0,0,1,
				1,0,0,0,0,0,0,1,
				1,1,1,1,1,1,1,1
				};
//		System.out.println(a.length);
		
		for(int i=0;i<a.length;i++){
			if(a[i]==1){
				System.out.print("*");
			}else if(a[i]==0){
				System.out.print(" ");
			}
//			System.out.print("*");
			if((i+1)%8==0){
				System.out.println();
			}
		}
	}

}
