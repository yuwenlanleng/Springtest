package com.zhk.test.DynamicProxyPrinciple;


public class Client {
	public static void main(String[] args) throws Exception {
		Tank target = new Tank();//���������
		InvocationHandler timeInvocationHandler = new TimeInvocationHandler(target);//�������
		
		Moveable proxyMoveable = (Moveable)Proxy.newProxyInstance(Moveable.class, timeInvocationHandler);//ͨ����̬����ʵ�ִ����õ��������
		
		proxyMoveable.move();
	}
}
//���Զ�����Ķ�������Ľӿڷ�����ʵ������Ĵ���