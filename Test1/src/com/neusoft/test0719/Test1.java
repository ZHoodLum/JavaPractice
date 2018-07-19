package com.neusoft.test0719;

import java.io.IOException;

public class Test1 {
	
	
	public static void main(String[] args) {
		//异常：运行时  出现的错误，而不是编译时出现的错误
		/**
		 * 不需要对异常做处理
		 * eg:数组下标越界。。。。等
		 * 
		 * 需要对异常做处理 解决异常报错
		 * Exception in thread "main" java.lang.StackOverflowError
		 * 
		 * 
		 */
	
//		method1();
		
		int[] b;
		try {
			b = new int[5];
			//数组下标越界
			System.out.println(b[6]);
		} 
		catch (NullPointerException e) {
//			e.printStackTrace();
			System.err.println("空指针异常");
		}
		//自行捕获异常 并处理  继续向下运行
		catch (ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
			System.err.println("数组下标越界异常");
		}
		catch(Exception e){
			System.out.println("出现异常！");
		}
		finally{
			System.out.println("不管try是否有异常，不论catch到异常与否，都会会执行finally方法！");
		}
		System.out.println("----");
		
		
		
	}
	
	static void  method1(){
		method1();
	}
    void  method2() throws IOException{
    	
    	//出现检查性异常 必须解决解决方式：1、try catch  2、声明throws异常
		System.out.println("IOException");
	}
	void  method3(){
		try {
			method2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void method4() throws IOException{
		method2();
	}
/**
 * 
 * throw抛出异常
 * 
 * throws声明异常  有可能出现问题的异常类型
 */
	//次方法中有异常 所以要向上抛  谁调用我 谁需要解决异常
	void method5()throws IOException{
		throw new ArrayIndexOutOfBoundsException();//属于非检查性异常  
//		throw new IOException;  //属于检查性异常   
	}
	
}
