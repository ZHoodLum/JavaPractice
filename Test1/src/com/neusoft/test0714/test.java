package com.neusoft.test0714;

import java.util.List;

public class test {

	public static void main(String[] args) {
		String[][] s = new String[][] { {  " 张三","28" },
				{"李强","23" }, {"王五","26" },
				{"李艳 ","25" }, {"张庆","22" } };
		test ts = new test();
		ts.sort(s);
		ts.traverse(s);
	}
	
	private void sort(String[][] s) {
		
		for (int j = 0; j < s.length ; j++) {
			for (int i = 0; i < s.length - 1; i++) {
				String[] temp;
				if (s[i][1].compareTo(s[i + 1][1]) > 0) {
					temp = s[i];
					s[i] = s[i + 1];
					s[i + 1] = temp;
					
				}
			}
		}
	}
	private void traverse(String[][] s) {
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				System.out.print(s[i][j] + " ");
			}
			System.out.println();
		}
	}

}
