package com.tydic.study.reflect;

import java.lang.reflect.Method;

public class TestClassLoad {

	public static void main(String[] args) throws Exception{
		Class<?> clz = Class.forName("com.tydic.study.reflect.Foo");
		Object o = clz.newInstance();
		Method m = clz.getDeclaredMethod("foo", String.class);
		for(int i=0;i<17;i++){
			m.invoke(o, Integer.toString(i));
		}
	}
}
