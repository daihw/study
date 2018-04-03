package com.tydic.study.async;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Count {

	public static void main(String[] args){
		long start = System.currentTimeMillis();
		Count count = new Count();
		List<Integer> res = new ArrayList<Integer>();
		 res.add(count.random());
         res.add(count.random());
         res.add(count.random());
         res.add(count.random());
         int totle =0;
         for (int i = 0; i < res.size(); i++) {
           totle+=res.get(i);
         }
        long end = System.currentTimeMillis();
         System.out.println("运算结束 耗时："+(end-start)+"ms  totle："+totle );
         System.out.println("退出main线程！");
    }

	int random(){
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //
	   return new Random().nextInt(100);
	}
}
