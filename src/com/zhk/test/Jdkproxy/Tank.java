package com.zhk.test.Jdkproxy;

public class Tank implements Moveable{

	@Override
	public void move() {
		System.out.println("坦克正在移动……");
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("正在删除……");
	}

}
