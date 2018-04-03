package com.tydic.study.annokit.test;

import com.tydic.study.anno.processor.ReflectProcessor;
import com.tydic.study.annokit.annotation.Reflect;

public class ReflectTest {
	@Reflect
	public String myName;
	
	@Reflect
	public static void sayHello(final String name){
		System.out.println("==>>Hi,"+name+" [sayHello]");
	}

	@Reflect(name="AngelaBaby")
	public static void sayHelloToSomeOne(final String name){
		System.out.println("==>>Hi,"+name+" [sayHelloToSomeone]");
	}
	
	public static void main(String[] args) throws Exception{
		//String str = "";
		//String[] strArr = str.split(",");
		//System.out.println(strArr.length);
		final ReflectProcessor reflectProcessor = new ReflectProcessor();
		reflectProcessor.parseMethod(ReflectTest.class);
	}
}
