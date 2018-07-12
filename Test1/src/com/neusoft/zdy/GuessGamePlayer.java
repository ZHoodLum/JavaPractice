package com.neusoft.zdy;

public class GuessGamePlayer {
//	要被猜测的数字
	int number = 0;
	
	public void guess() {
		number = (int) (Math.random() * 10);
		System.out.println("i am guessing" + number);
	}
}

