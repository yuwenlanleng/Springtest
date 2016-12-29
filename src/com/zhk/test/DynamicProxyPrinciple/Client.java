package com.zhk.test.DynamicProxyPrinciple;


public class Client {
	public static void main(String[] args) throws Exception {
		Tank target = new Tank();//被代理对象
		InvocationHandler timeInvocationHandler = new TimeInvocationHandler(target);//代理对象
		
		Moveable proxyMoveable = (Moveable)Proxy.newProxyInstance(Moveable.class, timeInvocationHandler);//通过静态方法实现代理，得到代理对象，
		
		proxyMoveable.move();
	}
}
//可以对任意的对象、任意的接口方法，实现任意的代理