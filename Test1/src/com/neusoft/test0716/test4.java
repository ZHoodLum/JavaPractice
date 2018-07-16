package com.neusoft.test0716;

import java.util.Arrays;
import java.util.TreeSet;

public class test4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.冒泡排序
		//2.输入不超过5位数 实现逆序 输出
		//3. 1/2+2/3+3/4+.......99/100=?求结果
		
		//4. int[] a={12,34,54,33,31,67,33,98,31,87};
		// 定义数组b 将去重后的a数组 拷贝到b数组中
		//a数组是正整数集合
		int[] a={12,34,54,33,31,67,33,98,31,87};
		int[] c=new int[a.length]; //{0,0,0.....}
		//    {12,34,54,33,31,67,0}
		//i=0  12 
		//i=1  12,34
		//i=2  12,34,54
		//i=3  12,34,54,33
		//....
		//i=5  12,34,54,33,31,67
		//i=6  12,34,54,33,31,67,33==>0
		//i=6   12 ~33    34 ~33   54~33 [33~33]不用比较 break;
 		  
		for(int i=0;i<a.length;i++){
			boolean flag=false;  //如果出现重复 true , 不重复false   
		     
			for(int j=0;j<i;j++){  //控制比较次数
			   if(a[i]==a[j]){  //出现了重复
				   flag=true;
				   break;
			   }else{
				   flag=false;
			   }
			}
			
			if(flag==true){
				c[i]=0;
			}else{
				c[i]=a[i];//赋值
			}
			
		}
		
		for(int n:c){
			System.out.print(n+",");
		}
		
		//b数组有多长
		int blen=0;
		for(int i=0;i<c.length;i++){
			if(c[i]!=0){
				blen++;
			}
		}
		System.out.println();
		System.out.println(blen);
		
		//定义b数组
		int[] b=new int[blen];
		int j=0;
		//将c数组 拷贝到b数组当中   不包括0;
		for(int i=0;i<c.length;i++){
			
			if(c[i]==0){
				
			}else{
				b[j]=c[i];
				j++;
			}
			
		}
		// 遍历b数组
		for(int n:b){
			System.out.print(n+",");
		}
		
		
	}

//		TreeSet ts = new TreeSet();
//		for(String s:a) {
//		    ts.add(s);
//		}
//		String[] array = (String[])ts.toArray(new String[]{});
//		System.out.println(Arrays.toString(array));
//		//数组拷贝
//		String[] b = new String[1];
//		System.arraycopy(a, 0, b, 0, a.length);
//		
//		for(String n:b){
//			System.out.print(n);
//		}


}
