package com.neusoft.test0723JiHe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test3 {
	public static void main(String[] args) {
		/**
		 * 数组要有统一的数据类型
		 * List接口<>泛型， 存取顺序一致，------》有序，可重复
		 * 
		 * 初始值10   每次扩容1.5倍   查找快 增删慢  数组结构
		 */
		List list = new ArrayList();
		//创建一个int类型的数组
//		int[] a = new int[10];
		Integer[] a = new Integer[10];
		String[] b = new String[10];
		
		a[0] = 1;
		System.out.println(a[0]);
		b[0] = "aaaa";
		System.out.println(b[0]);
		
		//int ---->String
		b[0] = 1 + "";
		
		//Object是所有类的父类
		//显然 这样的数据是没有灵魂的  我要装相同数据类型的数据，这时候就要用到泛型
		Object[] c = new Object[10];
		c[0] = 111;
		c[1] = "aaa";
		System.out.println(c[0]+" "+c[1]);
		/*
		* 使用泛型 <>   里面定义数据类型
		* 使用集合 应学会如何去遍历数组
		 */
		List<String> list1 = new ArrayList<>();
		list1.add("古天乐");
		list1.add("渣渣会");
		list1.add("爱迪生");
		list1.add("贝多芬");
		list1.add("孙红雷");
		list1.add("王思聪");
		//删除数据  数据位置
		list1.remove(1);
		//根据数组下标进行修改
		list1.set(1, "想改我渣渣辉！");
		//查询第一次出现指定元素的索引  如果不包含该元素  则返回-1
		System.out.println(list1.indexOf("HHH"));
//		System.out.println(list1);
		
		System.out.println("------------------------");
		//对数组进行遍历
		//1、List(arrayList)  把集合转换为数组 再遍历数组

		Object[] o = list1.toArray();
		for(Object n:o){
			System.out.println(n);
		}
		System.out.println("------------------------");
		//2、迭代器  iterator 使用泛型  保证数据为String类型数据
		ListIterator<String> i1 = list.listIterator();
//		Iterator<String> i1 = list1.iterator();
		while(i1.hasNext()){//判断 不移动指针

			String a1 = i1.next();//判断 移动指针
			if(a1 == "孙红雷"){
				i1.remove(); //使用迭代器来操作
				i1.add("黛埃迪");			//	c.Integer  没有add方法，再操作list集合想使用add方法需要使用ListIterator
			}		
			System.out.println(a1);
		}
		System.out.println(list1);
	}
}
