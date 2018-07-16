package com.neusoft.test0716;


//查看Person
public class Test6 {
	
	public static void main(String[] args) {
		//Person
		/**
		 * 姜磊是一个对象，王旭
		 * 认识人妈生的，对象是new出来的
		 * 想要new对象   ： 类名  对象名 = new 类名（）；
		 */
		Person jl = new Person();
		jl.name="蒋磊";
		jl.duixiang = true;
		jl.say();
		
		System.out.println("------------------------");
		
		Person wx = new Person();
		wx.name="王旭";
		wx.say();
		
	}

}
