package com.neusoft.test0717;

public class Test1 {
	//垃圾回收机制
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AA aa = new AA();//构造方法 在我们的new 类名（） 时就已经调用了
		System.out.println("------------");
		BB bb = new BB();//new 那个类 就调用那个类的构造方法
		System.out.println("------------");
		CC cc = new CC(6);
		//如果当前类已经有了有参构造器，则需要显示的写空参构造，否则new空参构造时报错
		System.out.println("------------");
		CC cc1 = new CC();
		
		/**
		 * 方法重载，只跟 1、参数个数  2、参数类型有关
		 * 
		 * 构造方法也可以进行重载 ，只跟 1、参数个数  2、参数类型有关
		 */
		System.out.println("------------");
		CC cc3 = new CC("aaa");
		System.out.println("------------");
		cc3.cc();//普通的方法
		System.out.println("------------");
		cc3.method3();
		System.out.println("------------");
		/**
		 * 局部变量高于全局变量（成员变量）
		 */
		cc3.method2();
		System.out.println("------------");
		cc3.method1(1);
		System.out.println("------------");
		cc3.method4();
		System.out.println(cc3.a);
		System.out.println("---使用this来区分成员与局部变量-----");
		cc3.method5(6666);
		System.out.println(cc3.a);
	}

}
