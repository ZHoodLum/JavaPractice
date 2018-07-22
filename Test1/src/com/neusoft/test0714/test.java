package com.neusoft.test0714;

import java.util.List;

public class test {

	public static void main(String[] args) {
		String[][] s = new String[][] { {  "SD","66" },
				{"GG","59" }, {"DD","77" },
				{"AA","99" }, {"EE","88" } };
		test ts = new test();
		ts.sort(s);
		ts.traverse(s);
		int rows = s.length;//行数
		int columns = s[0].length;//列数
		
		System.out.println( rows);
		System.out.println(  columns);
		System.out.print("最高成绩学生姓名：" +s[4][0] +","+ "成绩分数为："+ s[4][1]);

	}
	//对数组进行排序
	protected void sort(String[][] s) {
		
		for (int j = 0; j < s.length ; j++) {
			for (int i = 0; i < s.length - 1-j; i++) {
				String[] temp;
				if (s[i][1].compareTo(s[i + 1][1])>0) {
					temp = s[i];
					s[i] = s[i + 1];
					s[i + 1] = temp;
					
				}
			}
		}
	}
	//对数组进行遍历
	protected void traverse(String[][] s) {
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				System.out.print(s[i][j] + " ");	
			}
//			System.out.print(s[4][1] + " ,");
			System.out.println();
		}	
	}
	
					

}
