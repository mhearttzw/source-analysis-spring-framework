package org.springframework.demo.bean;

public class A {
	private B b;

	/**
	 * 构造函数注入
	 */
	public A(B b) {
		this.b = b;
	}

	/**
	 * 提供无参构造，如果不提供的话
	 * 使用setter注入会报错找不到init
	 */
	public A() {
	}

	/**
	 * Setter注入
	 */
	public void setB(B b) {
		this.b = b;
	}

	public void sayHello() {
		System.out.println("A hello");
		b.sayHello();
	}
}