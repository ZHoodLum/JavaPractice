package com.neusoft.zdy;

public class Beersong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int beernum = 99;
		String word = "boottles";
		
		while(beernum >0) {
			if(beernum == 1) {
				word = "bottles"; //单数的瓶子
			}
			
			System.out.println(beernum + "" + word + " of beer on the wall ");
			System.out.println(beernum + "" + word + " of beer. ");
			System.out.println(" Take one down ");
			System.out.println(" Pass it around. ");
			beernum = beernum -1;
			
			if(beernum >0) {
				System.out.println(beernum + "" + word + " of beer on the wall ");
			}else {
				System.out.println("No more bottles of beer on the wall");
			}//else结束
		}//while结束
	}//main结束

}//calss结束
