package com.tydic.study.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Transformer implements ClassFileTransformer {
	private final String injectedClassName = "com.tydic.study.agent.AgentTest";
	private final String methodName = "hello";

	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer)
			throws IllegalClassFormatException {
		// TODO Auto-generated method stub
        System.out.println("c1:"+className);  
		className = className.replace("/", ".");
        System.out.println("c2:"+className);  
		if (className.equals(injectedClassName)){
			CtClass ctclass = null;  
            try {  
                ctclass = ClassPool.getDefault().get(className);// 使用全称,用于取得字节码类<使用javassist>  
                CtMethod ctmethod = ctclass.getDeclaredMethod(methodName);// 得到这方法实例  
                ctmethod.insertBefore("System.out.println(11111111);");  
                return ctclass.toBytecode();  
            } catch (Exception e) {  
                System.out.println(e.getMessage());  
                e.printStackTrace();  
            }  
        }  
		return null;
	}

}
