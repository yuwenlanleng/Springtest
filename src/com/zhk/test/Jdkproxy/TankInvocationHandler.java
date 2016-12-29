package com.zhk.test.Jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TankInvocationHandler implements InvocationHandler {
	Object target;

	public TankInvocationHandler(Object target) {
		super();
		this.target = target;

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		if (method.getName().equals("move")) {
			System.out.println("�ƶ���ʼ����");
			result = method.invoke(target, args);// ��һ������ʱָ����method�����Ķ��󣬵ڶ�������ʱָ������÷����еĲ���
			System.out.println("�ƶ���������");
		} else if (method.getName().equals("delete")) {
			System.out.println("ɾ����ʼ����");
			result = method.invoke(target, args);
			System.out.println("ɾ������");
		}
		return result;
	}

}
