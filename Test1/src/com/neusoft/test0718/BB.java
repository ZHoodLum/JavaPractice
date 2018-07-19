package com.neusoft.test0718;

public class BB {
	
	/**
	 * 单例模式
	 * 不允许外部new多个
	 * 
	 * //懒汉式单例模式
	 * 一调用getInstance方法时  就实例化对象
	 */
	
	
	private BB(){
		
	}
	//成员变量  因为是private 外部不允许new多个  只能自己new 
	private static BB bb = null;
	
	public static BB getInstance(){
		if(bb == null){
			bb = new BB();
		}
		return bb;
		
	}
	
	
	
	
	
	
}
