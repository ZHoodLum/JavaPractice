package com.neusoft.test0716;

public class Test5 {
	public static void main(String[] args) {
		//先有类 再有对象
		//创建对象
		//根据用电器模板，创建手机对象
		Yongdianqi shouji = new Yongdianqi();
		
		//调用dianliang 并赋值
		shouji.dianliang=99;
		
		System.out.println(shouji.dianliang);
		//创建对象，调用跑电方法
		shouji.paodian();
	}
}
