package com.neusoft.test0712;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =0;
		while(true){
			a++;
//			System.out.println(a);
//			if(a>10){
//				break;
//			}
			if(a%10==0){
				continue;//����Ĵ��벻ִ�У����ǽ��뵽дһ��ѭ���жϵ���
			}else{
				System.out.println(a);
			}
		}
	}

}
