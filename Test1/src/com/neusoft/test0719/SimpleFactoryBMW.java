package com.neusoft.test0719;

public class SimpleFactoryBMW {
	
	//工厂如何去创建车   工厂类帮我们创建new
	
	public BMW makecar(String type){
		
		BMW b1 = null;
		if(type.equals("BMW320")){
			b1 = new BMW320();//这个是多态
		}else if(type.equals("BMW523")){
			b1 = new BMW523();
		}
		
		
		return null;
	}
	
}	
