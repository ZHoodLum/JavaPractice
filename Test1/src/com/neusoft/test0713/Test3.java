package com.neusoft.test0713;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//由小到大进行排序
		int[] a = {23,13,45,6,78,12,4,1};
		//冒泡排序

		//循环a.length次
		//循环开始时间
		long start = System.currentTimeMillis();
		//循环次数 可以控制时间
		for(int k=0;k<1000;k++){
		for(int j=0;j<a.length;j++){
			
			//1\最大值放在提取出来13 23 6 45 12 4 1 78
			//1\第二大放在提取出来13 6 23 12 4 1 45 78
			//每次排序进行比较
//			for(int i=0;i<a.length-1;i++) 加j与不加j区别  需要优化
			for(int i=0;i<a.length-1-j;i++){
				if(a[i]>a[i+1]){
					int temp = 0;
					//a[i]  a[i+1] 进行位置互换
					temp =a[i+1];
					a[i+1]=a[i];
					a[i]=temp;
				}
			}	
		}}
		//循环结束时间
		long end = System.currentTimeMillis();
		System.out.println("计算时间;"+(end-start));
		//输出
		for(int n:a){
			System.out.print(n+"  ");
		}
		
		
	}

}
