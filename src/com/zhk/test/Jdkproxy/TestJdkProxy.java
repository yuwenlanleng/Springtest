package com.zhk.test.Jdkproxy;

import java.lang.reflect.Proxy;

public class TestJdkProxy {
	public static void main(String []args){
	Moveable tankTarget = new Tank();
	TankInvocationHandler tankInvocationHandler = new TankInvocationHandler(tankTarget);
	Moveable tankProxyClass = (Moveable)Proxy.newProxyInstance(
			tankTarget.getClass().getClassLoader(),//��һ��������ָ���ĸ��������������������
			//��Ϊ�������ͱ����������һ�����͵ģ���������Ҫд���������classloader 
			tankTarget.getClass().getInterfaces(),//�ڶ���������ָ��������Ľӿ�����Щ�ӿڣ� Ҳ����д��new class[]{Moveable}
			//��Ϊʵ�ֵĽӿڿ��ܲ�ֹһ�����ӿڿ��Զ�ʵ��
			tankInvocationHandler);//������������ָhandler(Ҳ���ǼӴ����߼��Ĵ�����)
			tankProxyClass.move();
			tankProxyClass.delete();//���Զ������
	}
	
	
}
