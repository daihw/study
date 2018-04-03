package com.tydic.study.reflect;

import java.lang.reflect.Method;

public class SpeedTrap2 {
	 public static void doNothing(int x, int y, int z) { }  
     
	    private static void test(Method method) throws Throwable {  
	        for (int i = 0; i < 100000; i++) {  
	            method.invoke(null, 1, 2, 3);  
	        }  
	    }  
	      
	    public static void main(String[] args) throws Throwable {  
	        Method method = SpeedTrap2.class  
	                        .getMethod(  
	                            "doNothing",  
	                            int.class, int.class, int.class);  
	        // warm up  
	        for (int i = 0; i < 10; i++) {  
	            test(method);  
	        }  
	          
	        // time the test  
	        long start = System.nanoTime();  
	        test(method);  
	        long end = System.nanoTime();  
	        System.out.println("elapse time: " + (end - start));  
	    }  
}
