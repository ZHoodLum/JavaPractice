package com.neusoft.test0716;
/**
 * 	查看Test6
 *   class 类名{
 *		//属性
 *		//定义成员变量
 *		int a = 10;
 *		//定义成员方法
 *		public void aa(){}
 *
 *
 *
 *   }
 */
//人    类
public class Person {

//	是否有对象
//	属性	
//	以下这种形式  是成员变量
	boolean duixiang = false;
	String name;

	
//	吃饭是一个行为
//	行为翻译成方法	
//	以下这种方法   是成员方法
	public void eat(){
		System.out.println("吃饭");
	}
	//说话  行为
	public void say(){
		System.out.println("你好，我叫："+name);
		if(duixiang==false){
			System.out.println("家里有矿啊！还要对象。");
		}else{
			System.out.println("双身狗！");
		}
	}
	
}
