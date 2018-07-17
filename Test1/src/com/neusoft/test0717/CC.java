 package com.neusoft.test0717;

public class CC {
	
	
	/**
	 * 这样 称之为有参构造方法
	 * 想要调用有参的方法  需要在new时  写成new(参数[实参])
	 */
	public CC(int a){
		
		//成员方法与构造方法相同，在区分局部变量与成员变量同名问题是 使用this.解决
		this.a = a;
		System.out.println("这里是int+CC！"+a);
	}
	
	//无参构造方法
	public CC(){
		/**
		 * 在构造器当中 可以调用普通方法
		 * 在构造器当中 调用其它重载的  构造器使用this(参数)。参数个数、类型不同构造器也不同
		 * this要写在第一行
		 */
		this("aaaaaaa");
		CC("aaaaa");
		System.out.println("这里是无参构造方法！");
	}
	public CC(String a){
		System.out.println("这里是String构造方法+CC！"+a);
	}
	public void CC(String a){
		System.out.println("这里是String成员方法+CC！"+a);
	}
	public void cc(){
		System.out.println("返回值类型为空的CC（）方法！");
	}
	
	
	int a=10;
	
	public void method1(int a){
		/**
		 * 形参中的A 也是局部变量
		 */
		System.out.println("我是方法1  a="+a);
	}
	public void method2(){
		int a=5;
		System.out.println("我是方法2  a="+a);
	}
	public void method3(){
		System.out.println("我是方法3  a="+a);
	}
	public void method4(){
		/**
		 * 这里的A是成员变量的A    
		 * 因为没有从新定义基本类型的A值
		 * 而是直接使用的成员变量的int a。
		 */
		a=16;
		System.out.println("我是方法4  a="+a);
	}
	
	public void method5(int a){
		/**
		 * 使用this来区分成员变量与局部变量中的A
		 * 其中this.a 指向的是成员变量
		 */
		this.a = a;
		System.out.println("我是方法5  a="+a);
	}
	
}
