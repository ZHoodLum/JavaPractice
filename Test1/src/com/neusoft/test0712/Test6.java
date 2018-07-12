package com.neusoft.test0712;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		循环嵌套 for循环
//		for(int i=0;i<=7;i++){
//		
//			for(int j=0;j<=7;j++){
//				System.out.print("*");
//			}
//		System.out.println();		
//		}
		
//		输出结果不包含j>5   break 或者continue
//		只要出现j=6的情况，就跳出当前嵌套的for循环   可以使用标签 out  in 
		out:for(int i=0;i<10;i++){
			
			in:for(int j=0;j<10;j++){//外层循环执行一次，内层循环执行一次
				if(j<=6){
				System.out.println("i="+i+";j="+j);
				}else{
					break out;
				}
			}
		}
	
		out:for(int n=1;n<10;n++)
			switch(n){
			case 1: System.out.println(1);break;
			case 2: System.out.println(2);break;
			case 3: System.out.println(3);break out;
			case 4: System.out.println(4);break;
			case 5: System.out.println(5);break;
			case 6: System.out.println(6);break;
			default:System.out.println("其他");
		}
		
	}

}
