package com.tydic.study.anno.processor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.tydic.study.annokit.annotation.Reflect;

public class ReflectProcessor {
	public void parseMethod(final Class<?> clazz ) throws Exception{
		final Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
		final Method[] methods = clazz.getDeclaredMethods();
		final Field[] fields = clazz.getDeclaredFields();
		for(final Method method : methods){
			final Reflect my = method.getAnnotation(Reflect.class);
			if(null!=my){
				method.invoke(obj, my.name());
			}
			
		}
		for(final Field field : fields){
			final Reflect myField = field.getAnnotation(Reflect.class);
			System.out.println(myField.name());
		}
	}

}
