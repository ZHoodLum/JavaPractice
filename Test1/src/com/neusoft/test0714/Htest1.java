package com.neusoft.test0714;

import java.util.Random;

public class Htest1 {
	public static void main(String[] args) {
		randomball();
	}
	
	//公共方法 用于遍历数组
	public static void bianliArray(int[] a){
		System.out.println("数组为：");
		for(int n:a){
			System.out.print(n+" ");
		}
		System.out.println();
	}
	//随机生成6个红球  1-33    不重复 随机生成一个篮球 1-16
	public static void randomball(){
		Random r = new Random();
		//生成篮球
		int blueball = r.nextInt(16)+1;
		System.out.println(blueball);
		//生成红球6个 用数组
		int[] redballArray = new int[6];
//		redballArray[0] = r.nextInt(33)+1;
		//生成一个数 跟之前的进行比较
		
		for(int i=0;i<6;i++){//控制指针
			//第一位数字
			if(i==0){
				redballArray[i] = r.nextInt(33)+1;
			}
			//第二位数字
			else if(i==1){
				int randomred = r.nextInt(33)+1;
				//如果与前一个数相同  则从新生成
				while(true){
					if(randomred!=redballArray[i-1]){		
						randomred = r.nextInt(33)+1;
					}else{
						break;//直到不相等
					}
					redballArray[i] = randomred;
				}
				
			}
			//第三位数字
			else if(i==2){
				int randomred = r.nextInt(33)+1;
				//如果与前一个数相同  则从新生成
				while(true){
					if(randomred!=redballArray[i-2]){		
						randomred = r.nextInt(33)+1;
					}else{
						break;//直到不相等
					}
					redballArray[i] = randomred;
				}
				
			}
			
		}
		
		
		bianliArray(redballArray);
		
	}
}	
