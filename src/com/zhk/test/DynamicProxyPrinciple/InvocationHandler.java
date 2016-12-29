package com.zhk.test.DynamicProxyPrinciple;

import java.lang.reflect.Method;

public interface InvocationHandler {
	public void invoke(Object o, Method m);
}
