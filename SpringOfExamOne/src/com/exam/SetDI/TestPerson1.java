package com.exam.SetDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson1 {
	public static void main(String[] args) {
		ApplicationContext actx=new ClassPathXmlApplicationContext("beans.xml");
		Person person1=(Person)actx.getBean("person1");
		System.out.println("�ҵ���Ϣ�ǣ�");
		System.out.println("������"+person1.getName());
		System.out.println("����:" +person1.getAge());
		System.out.println("�ҵ�������"+person1.getFriend());
	
	}
}
