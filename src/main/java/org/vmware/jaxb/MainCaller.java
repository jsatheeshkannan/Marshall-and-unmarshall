package org.vmware.jaxb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCaller {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Marshall a = (Marshall)context.getBean("marshall");
		a.test1();
		

	}

}
