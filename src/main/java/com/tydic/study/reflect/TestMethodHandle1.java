package com.tydic.study.reflect;
import  java.lang.invoke.*;

public class TestMethodHandle1 {
	private static void hello(){
		System.out.println("Hello world");
	}
	
	public static void main(String[] args) throws Throwable{
		MethodType type = MethodType.methodType(void.class);
		MethodHandle method = MethodHandles.lookup().findStatic(TestMethodHandle1.class, "hello", type); 
		method.invoke();
	}
}
