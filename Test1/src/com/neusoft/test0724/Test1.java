package com.neusoft.test0724;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
	/**
	 * Map
	 */
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("吃鸡", "大吉大利");
		map.put("吃鸡", "下次！");
		map.put("雪", "血");

		map.get("吃鸡");
		/**
		 * 一夫一妻制
		 * k 值不能重复 value可重复 后面的会覆盖前面的  value后面的值好使
		 * 比如说喆喆后来居上  盖过了王宝宝
		 * map.put(k, value);
		 * 通过k值 找到value值
		 * 若相同的k值  只能取其中一个value值
		 * 
		 */
		System.out.println(map.get("吃鸡"));
//		System.out.println(map.get("大吉大利"));
		
		
		System.out.println("---------------");
		/**
		 * 一妻多夫制
		 * value可重复
		 * k值可重复
		 */
		map.put("王宝宝", "马蓉蓉");
		map.put("宋喆喆", "马蓉蓉");
		
		System.out.println(map.get("王宝宝"));
		System.out.println(map.get("宋喆喆"));
		
		
	}
	
	
	
	
}
