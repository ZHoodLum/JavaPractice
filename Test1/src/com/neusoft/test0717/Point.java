package com.neusoft.test0717;

public class Point {
	/**
	 * 定义一个点类Point，包含2个成员变量x、y分别表示x和y坐标，2个构造器Point()和Point(int x0,y0),
	 * 以及一个movePoint（int dx,int dy）方法实现点的位置移动，
	 * 创建两个Point对象p1、p2，分别调用movePoint方法后，打印p1和p2的坐标。
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

	
	//构造方法
	public Point(){
		x=2;
		y=2;
	}
	
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void show(){
		System.out.printf("此时的x轴坐标为"+x,    "y轴坐标为"+y);
	}
	public void movePoint(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	
	
}
