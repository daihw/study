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
                ctclass = ClassPool.getDefault().get(className);// ʹ��ȫ��,����ȡ���ֽ�����<ʹ��javassist>  
                CtMethod ctmethod = ctclass.getDeclaredMethod(methodName);// �õ��ⷽ��ʵ��  
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
