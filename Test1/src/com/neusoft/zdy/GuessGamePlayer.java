package com.neusoft.zdy;

public class GuessGamePlayer {
//	Ҫ���²������
	int number = 0;
	
	public void guess() {
		number = (int) (Math.random() * 10);
		System.out.println("i am guessing" + number);
	}
}

