package com.neusoft.test0717;

public class Point {
	/**
	 * ����һ������Point������2����Ա����x��y�ֱ��ʾx��y���꣬2��������Point()��Point(int x0,y0),
	 * �Լ�һ��movePoint��int dx,int dy������ʵ�ֵ��λ���ƶ���
	 * ��������Point����p1��p2���ֱ����movePoint�����󣬴�ӡp1��p2�����ꡣ
	 */
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	//���췽��
	public Point(){
		x=2;
		y=2;
	}
	
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void show(){
		System.out.printf("��ʱ��x������Ϊ"+x,    "y������Ϊ"+y);
	}
	public void movePoint(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	
	
}
