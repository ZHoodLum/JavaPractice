package com.exam.SetDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson1 {
	public static void main(String[] args) {
		ApplicationContext actx=new ClassPathXmlApplicationContext("beans.xml");
		Person person1=(Person)actx.getBean("person1");
		System.out.println("我的信息是：");
		System.out.println("姓名："+person1.getName());
		System.out.println("年龄:" +person1.getAge());
		System.out.println("我的朋友是"+person1.getFriend());
	
	}
}
