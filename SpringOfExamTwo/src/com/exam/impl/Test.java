package com.exam.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	public static void main(String[] args) throws Exception{
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		Performer per=(Performer)ctx.getBean("DukePerformer");  
		per.perform();  
		
		
	}
}
