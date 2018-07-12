package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exam.beans.Person;
import com.exam.service.PersonImpl;

public class SHTest {
 public static void main(String args[]){
  
  ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
  PersonImpl al=(PersonImpl)ctx.getBean("personDao");
  Person p=new Person();
  
  //调试后删掉以下注释
  //p.setUname("person");
  //p.insertUser(person);
  //p.isLogin("person");
  //p.printUser();
 }
}




