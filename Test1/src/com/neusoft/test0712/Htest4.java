package com.neusoft.test0712;

public class Htest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//for 行列进行打印
/*		for(int i=0;i<9;i++){
			
			for(int j=1;j<9;j++){
				System.out.print(" * ");
			}
			System.out.println(" * ");
		}
		System.out.println();
*/
		
		//while
		
/*		int i=0;
		while(i<9){
			i++;
			for(int j=1;j<9;j++){
				System.out.print(" * ");
			}
			System.out.println(" * ");
		}
	*/	
		//do while
		int a = 1;
		int s = 0;
		do{
			a++;
			for(int j=1;j<9;j++){
				System.out.print(" * ");
			}
			System.out.println(" * ");
		}while(a<9);
		
		
	}

}
