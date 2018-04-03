package com.tydic.study.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class SpeedTrap1 {
	
	public static void doNothing(int x,int y,int z){
		
	}
	
	private static void test(MethodHandle method){
		for(int i=0;i<100000;i++){
			try {
				method.invokeExact(1,2,3);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		MethodHandle  method = MethodHandles.lookup().findStatic(SpeedTrap1.class, "doNothing", 
				MethodType.methodType(void.class,int.class,int.class,int.class));
		for(int i=0;i<10;i++){
			test(method);
		}
		long start = System.nanoTime();
		test(method);
		long end = System.nanoTime();
		System.out.println("elapse time: " + (end - start));
	}

}
