package com.neusoft.test0719;

public class SimpleFactoryBMW {
	
	//�������ȥ������   ����������Ǵ���new
	
	public BMW makecar(String type){
		
		BMW b1 = null;
		if(type.equals("BMW320")){
			b1 = new BMW320();//����Ƕ�̬
		}else if(type.equals("BMW523")){
			b1 = new BMW523();
		}
		
		
		return null;
	}
	
}	
