package org.springframework;

import org.springframework.demo.bean.A;
import org.springframework.demo.bean.B;
import org.springframework.demo.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		A a = ac.getBean(A.class);
		B b = ac.getBean(B.class);
		System.out.println(a);
		System.out.println(b);
	}
}