package com.neusoft.test0724;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Test1.Person;

public class Test13ObjectFanxuliehua {
	public static void main(String[] args) throws IOException, Exception {
		
		///反序列化
		FileInputStream fis = new FileInputStream("C:\\Users\\15532\\Desktop\\项目\\iotest\\aaa.txt");
		ObjectInputStream oips1 = new ObjectInputStream(fis);
		
		Object obj = oips1.readObject();
		Person person1 = (Person)obj;
		System.out.println("名字是："+person1.getName()+"   年龄："+person1.getAge());
		fis.close();
		oips1.close();
	}
}
