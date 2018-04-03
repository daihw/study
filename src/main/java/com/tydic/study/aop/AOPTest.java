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
        System.out.println("�ҵ�������"+dog.getName());
        dog.setName("������");
        System.out.println("�ҵ�������"+dog.getName());
    }
    
    public static void main(String[] args) {
    	 
        AnimalInterface dog = AnimalFactory1.getAnimal(DogImp.class, new AOPMethod() {

			@Override
			public void after(Object proxy, Method method, Object[] args) {
				// TODO Auto-generated method stub
				System.out.println("ִ�з���ǰ");
			}

			@Override
			public void before(Object proxy, Method method, Object[] args) {
				// TODO Auto-generated method stub
				System.out.println("ִ�з�����");
			}
        });
        dog.say();
        String name1="�ҵ�������" + dog.getName();
        System.out.println(name1);
        dog.setName("������");
        String name2="�ҵ�������"+dog.getName();
        System.out.println(name2);
    }
    
}
