package com.zhk.test.StaticProxyPrinciple;

public class StaticProxy implements Moveable{

	Moveable t = new Tank();
	
	@Override
	public void move() {
		System.out.println("坦克移动开始时间:		"+System.currentTimeMillis());
		t.move();
		System.out.println("坦克移动结束时间:		"+System.currentTimeMillis());
		
	}

}
