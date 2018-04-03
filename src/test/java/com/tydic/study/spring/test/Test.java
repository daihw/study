package com.tydic.study.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tydic.study.spring.bean.People;

public class Test {
	
	public static void main(String[] args){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		People p = (People)applicationContext.getBean("342401198001204237");  
		System.out.println(p.getId());  
		System.out.println(p.getName());  
		System.out.println(p.getAge());
	}

}
