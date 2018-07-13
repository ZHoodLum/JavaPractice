package com.neusoft.test0713;

import java.text.ParseException;
import java.util.Arrays;
import java.util.TreeSet;

public class trangle6 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
	/*	有2个多维数组分别是 2 3 4   和  1 5 2 8 
        4 6 8       5 9 10 -3 
                    2 7 -5 -18
按照如下方式进行运算。生成一个2行4列的数组。此数组的第1行1列是2*1+3*5+4*2第1行2列是2*5+3*9+4*7  第2行1列是4*1+6*5+8*2 依次类推。（知识点：多维数组定义和创建、数组遍历、数组元素访问） [选作题]

2、将一个数组中的元素逆序存放
*/

//		将一个数组中的重复元素保留一个其他的清零
	        String[] a ={"1","2","2","3","3","3","6"};
	        TreeSet ts = new TreeSet();
	        for(String s:a) {
	            ts.add(s);
	        }
	        String[] array = (String[])ts.toArray(new String[]{});
	        System.out.println(Arrays.toString(array));
	 
	}

}
