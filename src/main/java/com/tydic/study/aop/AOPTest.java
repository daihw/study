package com.tydic.study.aop;

import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class AOPTest {
 
    @Test
    public void Test1() {
        AnimalInterface dog=AnimalFactory.getAnimal(DogImp.class);
        dog.say();
        System.out.println("我的名字是"+dog.getName());
        dog.setName("二狗子");
        System.out.println("我的名字是"+dog.getName());
    }
    
    public static void main(String[] args) {
    	 
        AnimalInterface dog = AnimalFactory1.getAnimal(DogImp.class, new AOPMethod() {

			@Override
			public void after(Object proxy, Method method, Object[] args) {
				// TODO Auto-generated method stub
				System.out.println("执行方法前");
			}

			@Override
			public void before(Object proxy, Method method, Object[] args) {
				// TODO Auto-generated method stub
				System.out.println("执行方法后");
			}
        });
        dog.say();
        String name1="我的名字是" + dog.getName();
        System.out.println(name1);
        dog.setName("二狗子");
        String name2="我的名字是"+dog.getName();
        System.out.println(name2);
    }
    
}
