package com.tydic.study.reflect;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class BootStrap {
	
	public static void hello(){
		System.out.println("Hello!");
	}
	
	public static CallSite bootstrap(MethodHandles.Lookup caller, String name, MethodType type) throws NoSuchMethodException, IllegalAccessException {  
        MethodHandles.Lookup lookup = MethodHandles.lookup();  
        Class thisClass = lookup.lookupClass();  
        MethodHandle mh = lookup.findStatic(thisClass, "hello", MethodType.methodType(void.class));  
        return new ConstantCallSite(mh.asType(type));  
    }  
}
