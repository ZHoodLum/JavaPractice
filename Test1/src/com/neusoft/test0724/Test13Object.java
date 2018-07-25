package com.neusoft.test0724;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Test1.Person;

public class Test13Object {
	public static void main(String[] args) throws IOException {
		/**
		 * 序列化流  ObjectInoutStream    ObjectOutputStream
		 * 序列化分为  序列化和反序列化
		 * 
		 * 若想实现序列化  必须实现序列化接口
		 * 序列化 （ ObjectOutputStream）  内存到外存叫做序列化  在堆内存当中创建对象 ，放到外存（硬盘）当中  称为序列化
		 * java.io.OutputStream -------->java.io.InputStream
		 * 
		 * 如果不想被序列化，解决办法： transient修饰符    static修饰
		 * 
		 * 
		 * 反序列化（ObjectInoutStream）   外存到内存  对象从外存拿到内存当中  成为反序列化
		 * 
		 * 
		 * 使用方法：writeObject(Object obj)
		 */
		Person jl = new Person();
		jl.setAge(18);
		jl.setName("蒋磊");
		
		FileOutputStream fops1 = new FileOutputStream("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.txt");
		
		//高级流
		ObjectOutputStream oop1 = new ObjectOutputStream(fops1);
		
		oop1.writeObject(jl);
		
		oop1.close();
		fops1.close();
		System.out.println("---");
		
		
	}
}
