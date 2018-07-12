package test;

import java.util.Scanner;

public class test2 {
	public static void main(String[] args) {
		//倒三角形
		int line=6;//定义行数
        for(int i=0;i<line;i++){
	        for(int j=0;j<i;j++){
	            System.out.print(" ");
	        }
	        //打印*的个数
	        for( int j=0;j<2*(line-i)-1;j++){
	            System.out.print("*");
	        }
	        //打印完*记得换行
	        System.out.println();
        }
        

        //打印一行
        //打印上半部分
        for(int i=0;i<line;i++){
            //打印i个空格
	        for(int j=0;j<line-1-i;j++){
	                System.out.print(" ");
	            }
	            //打印*的个数
	        for( int j=0;j<2*i+1;j++){
	            System.out.print("*");
	        }
	                //打印完* 记得换行
	            System.out.println();
        } 
		
		
		//控制台输入
//		   System.out.print("打印一个倒立的正三角形，底边长为（请输入大于或等于三的奇数）：");  
//		    Scanner in=new Scanner(System.in);  
//		    int m=in.nextInt();  
//		    int n=(m-1)/2;  
//		    String A=" ";  
//		    String B="*";  
//		    for(int i=0;i<=n;i++){  
//		        for(int j=0;j<=i;j++){  
//		            System.out.print(A);  
//		        }  
//		        for(int j=0;j<=2*n-2*i;j++){  
//		            System.out.print(B);  
//		        }  
//		        System.out.println();  
//		    }
	}
}
