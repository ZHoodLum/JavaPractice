package com.neusoft.zdy;
/*
 * 本次文件包含GuessGame.java   GuessGamePlayer.java    GuessGameLauncher.java 文件
 */
public class GuessGame {
//  用3个实例变量分别表示3个Player对象
	GuessGamePlayer p1;
	GuessGamePlayer p2;
	GuessGamePlayer p3;

	public void startGame() {
//		创建Player对象
		p1 = new GuessGamePlayer();
		p2 = new GuessGamePlayer();
		p3 = new GuessGamePlayer();
//		声明3个变量来保存是否猜中
		int guessp1 = 0;
		int guessp2 = 0;
		int guessp3 = 0;
//		声明3个变量来保存猜测的数字
		boolean p1isRight = false;
		boolean p2isRight = false;
		boolean p3isRight = false;
//		产生谜底数字   数字在0-9之间随机抽选
		int targetNumber = (int) (Math.random() * 10);
		System.out.println("i am thinking of a number between 0 and 9..");
		while(true) {
			System.out.println("Number to guess is"+targetNumber);
//			调用Player的guess()方法
			p1.guess();
			p2.guess();
			p3.guess();
//			取得每个Player所猜测的数字并将他列出
			guessp1 = p1.number;
			System.out.println("Player one guessed" + guessp1);
			
			guessp2 = p1.number;
			System.out.println("Player one guessed" + guessp1);
			
			guessp3 = p1.number;
			System.out.println("Player one guessed" + guessp1);
			
//			检查是否猜中,若是猜中则去设定是否猜中的变量
			if(guessp1 == targetNumber) {
				p1isRight = true;
			}
			if(guessp2 == targetNumber) {
				p2isRight = true;
			}
			if(guessp3 == targetNumber) {
				p3isRight = true;
			}
//			代表如果有一个或多个猜中
			if(p1isRight || p2isRight || p3isRight) {
				System.out.println("we have a winner!");
				System.out.println("player one got it right ?" + p1isRight);
				System.out.println("player two got it right ?" + p2isRight);
				System.out.println("player three got it right ?" + p3isRight);
				System.out.println("Game is over!");
//				游戏结束终止循环
				break;
			}else {
//				都没猜中 游戏继续 猜到你崩溃
				System.out.println("Player will have to try again!");
			}
			
			
		}
		
	}

}
