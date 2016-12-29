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
			System.out.println("移动开始……");
			result = method.invoke(target, args);// 第一个参数时指调用method方法的对象，第二个参数时指传入调用方法中的参数
			System.out.println("移动结束……");
		} else if (method.getName().equals("delete")) {
			System.out.println("删除开始……");
			result = method.invoke(target, args);
			System.out.println("删除结束");
		}
		return result;
	}

}
