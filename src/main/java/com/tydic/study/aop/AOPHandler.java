package com.tydic.study.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class AOPHandler implements InvocationHandler {
	//±£¥Ê∂‘œÛ
	private AOPMethod method;
	private Object o;
	public AOPHandler(Object obj,AOPMethod method) {
		// TODO Auto-generated constructor stub
		this.method = method;
		this.o = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object  ret = null;
		this.method.before(proxy, method, args);
		ret = method.invoke(o, args);
		this.method.after(proxy, method, args);
		return ret;
	}

}
