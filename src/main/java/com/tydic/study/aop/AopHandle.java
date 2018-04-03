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
		//方法返回值
		Object ret = null;
		//打印方法名称
		System.err.println("执行方法:"+method.getName()+"\n参数类型为:");
		//打印参数
		for(Class type:method.getParameterTypes()){
			System.err.println(type.getName());
		}
		//打印返回类型
        System.err.println("返回数据类型:"+method.getReturnType().getName());
        //反射调用方法
        ret=method.invoke(o, args);
        //声明结束
        System.err.println("方法执行结束");
        //返回反射调用方法的返回值
        return ret;
	}

}
