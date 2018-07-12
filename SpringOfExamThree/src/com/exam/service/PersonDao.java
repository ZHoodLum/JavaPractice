package com.exam.service;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.exam.beans.Person;

public class PersonDao extends HibernateDaoSupport implements PersonImpl {
	private SessionFactory sessionFactory=null;
	
 public void insertUser(Person user) {
  
  super.getHibernateTemplate().save(user);
 }
 public void printUser(){
	 ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	 SessionFactory sessionFactory=(SessionFactory)ctx.getBean("sessionFactory");
	 Session session=sessionFactory.openSession();
	 session.beginTransaction();
	 Query query=session.createQuery("from Person");
		List<Person> memeberList=query.list();
		Person person=null;
		if(memeberList!=null && memeberList.size()>0){
		    for(int i=0;i<memeberList.size();i++){
			person=(Person)memeberList.get(i);
			
			//输出序列号和用户名
			System.out.println(                         );
			}
		}			
		session.getTransaction().commit();
 }
 public boolean isLogin(String name){
  List list=getHibernateTemplate().find("from Person as p where p.name='"+name+"'");
  Iterator it=list.iterator();
  if(!it.hasNext()){
     System.out.println("登录失败");
     return false;
  }
  else{
     System.out.println("登录成功");
     return true;
  }
 }

}
