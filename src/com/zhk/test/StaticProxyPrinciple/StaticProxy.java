package com.zhk.test.StaticProxyPrinciple;

public class StaticProxy implements Moveable{

	Moveable t = new Tank();
	
	@Override
	public void move() {
		System.out.println("̹���ƶ���ʼʱ��:		"+System.currentTimeMillis());
		t.move();
		System.out.println("̹���ƶ�����ʱ��:		"+System.currentTimeMillis());
		
	}

}
