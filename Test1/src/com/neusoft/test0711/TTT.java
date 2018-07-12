package com.neusoft.test0711;

import java.util.Scanner;

public class TTT {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =new Scanner(System.in);
		while(true) {
		System.out.println("请输入初始坐标");
		int zb=sc.nextInt();
			for(int i=0;i<64;i++) {
				
				if(i<7||i>55||i%8==0) {
				System.out.print("*");
				}else if(i%8==7){
					System.out.print("*");
					System.out.println();
				}else if(i==zb){
					System.out.print("^");	
				}
				else {
				  System.out.print(" ");
				}
			}
			System.out.println();
			for(int k=0;k<10;k++) {
				String d = sc.next();
				if(d.equals("d") ) {
					for(int i=0;i<64;i++) {
						
						if(i<7||i>55||i%8==0) {
						System.out.print("*");
						}else if(i%8==7){
							System.out.print("*");
							System.out.println();
						}else if(i==zb+1){
							System.out.print("^");	
						}else {
						  System.out.print(" ");
						}
					}
					System.out.println();
				}else if(zb == 15){
					System.out.println("111");
					break;
				}	
			}
		}
	}
}
	
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		int l=8;
////		for(int i=0;i<=l;i++){
////	           
////	        for( int j=0;j<=l;j++){
////	            System.out.print("*");
////	        }
////	            System.out.println();
////        } 
//		Scanner sc = new Scanner(System.in);
//		System.out.println("请输入坐标：");
//		int b = sc.nextInt();
////		while(true) {
//		int l=20;
//		for (int i = 1; i <= l; i++) { 
//			
//            for (int j = 1; j <= l; j++) {  	
//                if (i == 1 || i ==l) {  
//                    System.out.print("*");  
//                } else {  
//                    if (j == 1 || j == l) {  
//                        System.out.print("*");  
//                    }
//                    else {  
//                        System.out.print(" ");  
//                    } 
//                }  
//            }
//            System.out.println();  
//		}
//            
//	}
////	}
//}
