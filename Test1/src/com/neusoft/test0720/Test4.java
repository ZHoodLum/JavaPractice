package com.neusoft.test0720;

public class Test4 {
	public static void main(String[] args) {
		
		//由String类型转换为StringBuffer类型
		
		//方法1 构造方法StringBuffer(String s)
		String a = "abc";
		StringBuffer sb = new StringBuffer(a);
		sb.append("bcd");
		System.out.println(sb.toString());
		
		//方法2 append(String s);
		StringBuffer sb1 = new StringBuffer();
		sb1.append(a);
		System.out.println(sb1);
		
		//Stringuffer
		//追加方法
		sb1.append("ghj");
		System.out.println(sb1);
		//插入方法
		sb1.insert(2, "Jury");
		System.out.println(sb1);
		//删除方法
		sb1.insert(2, 10);
		System.out.println(sb1);
		//查询方法
		int i = sb1.indexOf("b");
		System.out.println(sb1);
		//修改方法
		sb1.replace(0, 2, "YYYOP");
		System.out.println(sb1);
		
		
		
		//StringBuffer类型转换为String类型   用StringBuffer的toString（） 方法
		String b = sb.toString();
		System.out.println();
		
		
	}
}
