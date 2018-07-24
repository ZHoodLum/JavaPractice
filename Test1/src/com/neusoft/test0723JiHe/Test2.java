package com.neusoft.test0723JiHe;

import java.util.ArrayList;
import java.util.Collection;

public class Test2 {
	public static void main(String[] args) {
		
		//集合中可以自动扩容
		Collection c1 = new ArrayList();
		/**
		 * 
		 * Object是所有类的超类
		 * 也是包装数据类型的超类
		 * 因为 基本数据类型，性质：自动装箱：
		 * 所以int 类型的10   转换为integer类型的10   int 10  -----> integer  10
		 * 因为包装数据类型的超类，所以integer 10  相当于变为Object类型 的父类引用指向子类对象的引用  形式
		 * 所以10  可以放到方法的参数当中
		 */
		c1.add(10);
		c1.add(20);
		c1.add(30);
		c1.add(40);
		c1.add(50);
		c1.add(60);
		c1.add(70);
		c1.add(80);
		c1.add(90);
		
		c1.size();
		System.out.println(c1.size());
		System.out.println(c1.toArray());
		
		Object[] o1array = c1.toArray();
		/**
		 * 遍历数组
		 * 为甚麽可以遍历Object类型的数组？
		 * 在syso当中输出一个类相当于自动调用toString方法
		 * 因为有了，父类引用指向子类对象的形式，Object o = new Integer(10);
		 * 所以  调用toString方法是发生重写，实际调用的是Integer当中的toString方法  即输出数字10
		 */
		for(Object o:o1array){
			System.out.println(o);
		}
		
	}
}
