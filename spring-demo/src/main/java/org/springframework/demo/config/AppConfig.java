package org.springframework.demo.config;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.demo.bean.A;
import org.springframework.demo.bean.B;

/**
 * 描述：TODO...
 *
 * @author jorelwang
 * @create 2024-03-08 18:36
 */
// @Configurable
// @ComponentScan("org.springframework.demo.**")
public class AppConfig {

	public static void main(String[] args) {
		DefaultListableBeanFactory container = new DefaultListableBeanFactory();
		//向IOC中注入的是BeanDefinition而不是Bean，并绑定依赖关系
		RootBeanDefinition aDefinition = new RootBeanDefinition(A.class);
		RootBeanDefinition bDefinition = new RootBeanDefinition(B.class);

		//1、可以通过构造函数指定依赖关系
		// ConstructorArgumentValues argValues = new ConstructorArgumentValues();
		//
		// argValues.addIndexedArgumentValue(0,bDefinition);
		// aDefinition.setConstructorArgumentValues(argValues);

		//2、或者通过setter方式注入
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		//这里要指定成字段名字
		propertyValues.addPropertyValue(new PropertyValue("b",bDefinition));
		aDefinition.setPropertyValues(propertyValues);

		//将BeanDefinition注册到Container中去
		container.registerBeanDefinition("aDefinition",aDefinition);
		container.registerBeanDefinition("bDefinition",bDefinition);

		//获取A并测试
		A a = container.getBean(A.class);
		a.sayHello();

	}


}
