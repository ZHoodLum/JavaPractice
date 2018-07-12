package com.neusoft.test0712;

public class Test10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*
 * 	a[] 代表第几位数组  [] 代表第一个数组中的第几位数  相当于x,y轴
 */
		int[][] a = { {1,2,3},{2,3,6} };
		System.out.println(a[0][0]);
		
		System.out.println("------------二维数组for循环的遍历----------");
//		for(int i = 0;i<a.length;i++){//循环最外面的数组
//	        for(int j = 0;j<a[i].length;j++){//循环里面的数组
//	            System.out.print((a[i][j])+",");//弹出数组中的每一项
//	        }
//	    }

		System.out.println("while循环遍历");
/*		int i=0;
		int n=0;
		while(n<a.length){
			while(i<a[n].length){
				System.out.print(a[n][i]+",");
				i++;
			}
			i=0;
			n++;
			System.out.println();
		}
		
*/		
		
		System.out.println("while for结合循环遍历");
/*		int i=0;
		for(int n=0;n<a.length;n++){
			while(i<a[n].length){
				System.out.print(a[n][i]+",");
				i++;
			}
			i=0;
			System.out.println();
		}
		
*/		
		System.out.println("foreach结合循环遍历");
//		for(int[] b:a){
//			for(int n:b){
//				System.out.println(n+",");
//			}
//		}
		
		
	}

}
