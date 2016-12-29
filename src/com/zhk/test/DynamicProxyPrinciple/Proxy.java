package com.zhk.test.DynamicProxyPrinciple;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class Proxy {
	public static Object newProxyInstance(Class infce, InvocationHandler invocationHandler) throws Exception { //JDK6 Complier API, CGLib, ASM
		String methodStr = "";
		String rt = "\r\n";
		
		Method[] methods = infce.getMethods();

		for(Method method : methods) {
			methodStr += "	@Override" + rt + 
						 "	public void " + method.getName() + "() {" + rt +
						 "    	try {" + rt +
						 "    		Method method = " + infce.getName() + ".class.getMethod(\"" + method.getName() + "\");" + rt +
						 "    		invocationHandler.invoke(this, method);" + rt +
						 "    		}catch(Exception e) {"+ rt 
						 + "			e.printStackTrace();" + rt
						 + "		}" + rt +
						
						 "}";
		}
		
		String src = 
			"package com.zhk.test.dynamicProxyyuanli;" +  rt +
			"import java.lang.reflect.Method;" + rt +
			"public class $Proxy1 implements " + infce.getName() + "{" + rt +
			"    com.zhk.test.dynamicProxyyuanli.InvocationHandler invocationHandler;" + rt +
			"    public $Proxy1(InvocationHandler invocationHandler) {" + rt +
			"        this.invocationHandler = invocationHandler;" + rt +
			"    }" + rt +
							
			methodStr +
			"}";
		
		String fileName = 
			"d:/src/com/zhk/test/dynamicProxyyuanli/$Proxy1.java";//java的源码
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//compile
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();//获得java的编译器
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		//load into memory and create an instance
		URL[] urls = new URL[] {new URL("file:/" + "d:/src/")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.zhk.test.dynamicProxyyuanli.$Proxy1");
		System.out.println(c);
		
		Constructor ctr = c.getConstructor(InvocationHandler.class);
		Object m = ctr.newInstance(invocationHandler);
		//m.move();

		return m;
	}
}
