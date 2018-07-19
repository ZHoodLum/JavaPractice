package com.neusoft.test0718;

public class Test1 {
	public static void main(String[] args) {
		Weapon w1 = new Weapon();
		w1.atk();
		System.out.println("-----------");
		NearWeapon nw = new NearWeapon();
		nw.atk();
		System.out.println("-----------");
		LongWeapon lw = new LongWeapon();
		lw.atk();
	
	}
}
