package com.neusoft.test0716;

public class ChiJiPerson {
	/**
	 * ����
	 */
	String name="";
	int atk=10;
	int hp=100;
	char sex='��';//Ů
	int speed;//����
	String direction;//����
	
	boolean huozhe = true;
	/**
	 * ����
	 */
	
	//��
	public void move(){
		System.out.println("��");
	}
	//����
	public void hit(ChiJiPerson p1){
//		System.out.println("[[[��������ɱ����]]]");
		System.out.println(name+"���ڴ�"+p1.name);
		p1.hurt(atk);
	}
	//����
	public void hurt(int atk){
//		System.out.println("[[[�ֱ�����]]]");
		hp = hp-atk;
		System.out.println(name+"�ܵ�"+atk+"�㹥����ʣ��"+hp+"Ѫ��");
		if(hp<=0){
			todie();
		}
	}
	//�ɺ�
	public void todie(){
		huozhe = false;
		System.out.println(name+"�´�һ���ܳԼ���");
	}
	
}
