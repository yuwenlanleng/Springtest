package com.zhk.test.Jdkproxy;

import java.lang.reflect.Proxy;

public class TestJdkProxy {
	public static void main(String []args){
	Moveable tankTarget = new Tank();
	TankInvocationHandler tankInvocationHandler = new TankInvocationHandler(tankTarget);
	Moveable tankProxyClass = (Moveable)Proxy.newProxyInstance(
			tankTarget.getClass().getClassLoader(),//第一个参数是指用哪个对象来产生被代理对象，
			//因为代理对象和被代理对象是一样类型的，所以这里要写被代理类的classloader 
			tankTarget.getClass().getInterfaces(),//第二个参数是指被代理类的接口有哪些接口， 也可以写成new class[]{Moveable}
			//因为实现的接口可能不止一个，接口可以多实现
			tankInvocationHandler);//第三个参数是指handler(也就是加处理逻辑的代码类)
			tankProxyClass.move();
			tankProxyClass.delete();//测试多个方法
	}
	
	
}
