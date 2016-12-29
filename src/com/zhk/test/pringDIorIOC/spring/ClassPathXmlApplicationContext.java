package com.zhk.test.pringDIorIOC.spring;


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;


public class ClassPathXmlApplicationContext implements BeanFactory {
	
	private Map<String , Object> beans = new HashMap<String, Object>();
	

	//IOC Inverse of Control DI Dependency Injection
	public ClassPathXmlApplicationContext() throws Exception {
		SAXBuilder sb=new SAXBuilder();
	    
	    Document doc=sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml")); //构造文档对象
	    Element root=doc.getRootElement(); //获取根元素HD
	    List list=root.getChildren("bean");//取名字为disk的所有元素
//		<beans>
//		<bean id="u" class="com.zhk.test.pringDIorIOC.dao.impl.UserDAOImpl" />
//		<bean id="userService" class="com.zhk.test.pringDIorIOC.service.UserService" >
//			<property name="userDAO" bean="u"/>
//		</bean>
//		</beans>
		
	    for(int i=0;i<list.size();i++){
	       Element element=(Element)list.get(i);
	       String id=element.getAttributeValue("id");//u或则userService
	       String clazz=element.getAttributeValue("class");//com.zhk.test.pringDIorIOC.dao.impl.UserDAOImpl或则com.zhk.test.pringDIorIOC.service
	       Object o = Class.forName(clazz).newInstance();
	       System.out.println(id);
	       System.out.println(clazz);
	       beans.put(id, o);//把id和new出来的对象放入map中
	       
	       for(Element propertyElement : (List<Element>)element.getChildren("property")) {
	    	   String name = propertyElement.getAttributeValue("name"); //userDAO
	    	   String bean = propertyElement.getAttributeValue("bean"); //u
	    	   Object beanObject = beans.get(bean);//com.zhk.test.pringDIorIOC.dao.impl.UserDAOImpl
	    	   
	    	   String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
	    	   System.out.println("method name = " + methodName);
	    	   
	    	   Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);//第一个参数时方法名，第二个参数时方法里的参数
	    	   m.invoke(o, beanObject);//m.invoke(实际被new出来的对象,UserDAOImpl)
	       }
	       
	       
	    }  
	  
	}



	public Object getBean(String id) {
		return beans.get(id);
	}

}
