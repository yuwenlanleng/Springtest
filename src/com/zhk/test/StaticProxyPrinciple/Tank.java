package com.zhk.test.StaticProxyPrinciple;

public class Tank implements Moveable{

	@Override
	public void move() {
		System.out.println("坦克正在移动……");
	}

}
