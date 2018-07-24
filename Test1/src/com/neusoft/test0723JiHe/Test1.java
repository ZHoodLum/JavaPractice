package com.neusoft.test0723JiHe;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		
		
		int[] a = {12,23,34,53,6};
		//所谓的数组就是新分配一块内存空间
		System.out.println("old  "+a.length);
		System.out.println(a);
		
		int[] b = {12,23,34,53,6};
		System.out.println(b.length);
		
		a = Arrays.copyOf(a, 10);
		System.out.println("new  "+a.length);
		System.out.println(a);

		/**
		 * 数组中拷贝方法
		 * a 源数组 原数组中的开始位置
		 * b 目标数组  目标数组的开始位置  
		 * 拷贝长度 
		 */
		System.arraycopy(a, 0, b, 0, 5);
		
		for(int n:a){
			System.out.println(n);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
