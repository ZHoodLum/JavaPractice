package com.neusoft.test0716;

public class ChiJiPerson {
	/**
	 * 属性
	 */
	String name="";
	int atk=10;
	int hp=100;
	char sex='男';//女
	int speed;//速率
	String direction;//方向
	
	boolean huozhe = true;
	/**
	 * 方法
	 */
	
	//跑
	public void move(){
		System.out.println("跑");
	}
	//打人
	public void hit(ChiJiPerson p1){
//		System.out.println("[[[啊啊啊，杀银啦]]]");
		System.out.println(name+"正在打"+p1.name);
		p1.hurt(atk);
	}
	//被打
	public void hurt(int atk){
//		System.out.println("[[[又被打了]]]");
		hp = hp-atk;
		System.out.println(name+"受到"+atk+"点攻击，剩余"+hp+"血量");
		if(hp<=0){
			todie();
		}
	}
	//成盒
	public void todie(){
		huozhe = false;
		System.out.println(name+"下次一定能吃鸡！");
	}
	
}
