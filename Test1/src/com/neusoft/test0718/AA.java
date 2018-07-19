package com.neusoft.test0718;

public class AA {
	
	

	/**
	 * 饿汉式单例模式
	 * 当我一加载到静态方法区  就实例化对象
	 */
	private static AA instance = new AA();
	
	private AA(){
		
	}
	public static AA getInstance(){
		return instance;
	}
	
}
