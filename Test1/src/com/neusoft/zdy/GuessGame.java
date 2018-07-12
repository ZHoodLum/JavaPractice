package com.neusoft.zdy;
/*
 * �����ļ�����GuessGame.java   GuessGamePlayer.java    GuessGameLauncher.java �ļ�
 */
public class GuessGame {
//  ��3��ʵ�������ֱ��ʾ3��Player����
	GuessGamePlayer p1;
	GuessGamePlayer p2;
	GuessGamePlayer p3;

	public void startGame() {
//		����Player����
		p1 = new GuessGamePlayer();
		p2 = new GuessGamePlayer();
		p3 = new GuessGamePlayer();
//		����3�������������Ƿ����
		int guessp1 = 0;
		int guessp2 = 0;
		int guessp3 = 0;
//		����3������������²������
		boolean p1isRight = false;
		boolean p2isRight = false;
		boolean p3isRight = false;
//		�����յ�����   ������0-9֮�������ѡ
		int targetNumber = (int) (Math.random() * 10);
		System.out.println("i am thinking of a number between 0 and 9..");
		while(true) {
			System.out.println("Number to guess is"+targetNumber);
//			����Player��guess()����
			p1.guess();
			p2.guess();
			p3.guess();
//			ȡ��ÿ��Player���²�����ֲ������г�
			guessp1 = p1.number;
			System.out.println("Player one guessed" + guessp1);
			
			guessp2 = p1.number;
			System.out.println("Player one guessed" + guessp1);
			
			guessp3 = p1.number;
			System.out.println("Player one guessed" + guessp1);
			
//			����Ƿ����,���ǲ�����ȥ�趨�Ƿ���еı���
			if(guessp1 == targetNumber) {
				p1isRight = true;
			}
			if(guessp2 == targetNumber) {
				p2isRight = true;
			}
			if(guessp3 == targetNumber) {
				p3isRight = true;
			}
//			���������һ����������
			if(p1isRight || p2isRight || p3isRight) {
				System.out.println("we have a winner!");
				System.out.println("player one got it right ?" + p1isRight);
				System.out.println("player two got it right ?" + p2isRight);
				System.out.println("player three got it right ?" + p3isRight);
				System.out.println("Game is over!");
//				��Ϸ������ֹѭ��
				break;
			}else {
//				��û���� ��Ϸ���� �µ������
				System.out.println("Player will have to try again!");
			}
			
			
		}
		
	}

}
