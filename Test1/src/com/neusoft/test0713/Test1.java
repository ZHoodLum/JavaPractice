package com.neusoft.test0713;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int j=0;j<8;j++){
			for(int i=0;i<8;i++){
				//上下两侧
				if(j==0||j==7){
					System.out.print("*");
				}else{
					//中间
					if(i>0&&i<7){
						System.out.print(" ");
					}else{
						System.out.print("*");
					}
					
				}
				
			}
			System.out.println();
		}
	}

}
