package com.zhk.test.DynamicProxyPrinciple;

import java.lang.reflect.Method;

public class TimeInvocationHandler implements InvocationHandler{
	
	private Object target;

	public TimeInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method method) {
		long start = System.currentTimeMillis();
		try {
			method.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end-start));
	}

}
