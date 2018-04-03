package com.tydic.study.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AopHandle implements InvocationHandler {
	private Object o;
	public  AopHandle(Object o) {
		// TODO Auto-generated constructor stub
		this.o = o;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		//��������ֵ
		Object ret = null;
		//��ӡ��������
		System.err.println("ִ�з���:"+method.getName()+"\n��������Ϊ:");
		//��ӡ����
		for(Class type:method.getParameterTypes()){
			System.err.println(type.getName());
		}
		//��ӡ��������
        System.err.println("������������:"+method.getReturnType().getName());
        //������÷���
        ret=method.invoke(o, args);
        //��������
        System.err.println("����ִ�н���");
        //���ط�����÷����ķ���ֵ
        return ret;
	}

}
