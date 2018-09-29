package com.tydic.study.multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 
 * @this demo  display the hashmap infinite loop 
 *
 */
public class HashMapHangDemo {
	//final Map<Integer,Object> holder = new HashMap<Integer,Object>();
	//corret way is use concurrentHashMap 
	final Map<Integer,Object> holder = new ConcurrentHashMap<Integer,Object>();
	public static void main(String[] args){
		HashMapHangDemo demo = new HashMapHangDemo();
		for(int i=0;i<100;i++){
			demo.holder.put(i, "test");
		}
		Thread thread = new Thread(demo.getConcurrencyCheckTask());
		thread.start();
        thread = new Thread(demo.getConcurrencyCheckTask());
        thread.start();
        System.out.println("Start get in main!");
        for(int i = 0; ; ++i){
        	for (int j = 0; j < 10000; ++j) {
                demo.holder.get(j);

                // �������hashmap��get hangס���⣬�����������Ͳ����ٳ����ˡ�
                // ���ҵĿ������ϣ��������ڵ�һ�־͹۲쵽������⡣
                System.out.printf("Got key %s in round %s\n", j, i);
            }
        }
	}
	
	ConcurrencyTask getConcurrencyCheckTask() {
        return new ConcurrencyTask();
    }
	
	private class ConcurrencyTask implements Runnable{
		Random random = new Random();
		@Override
		public void run() {
			System.out.println("Add loop started in task");
			while(true){
				holder.put(random.nextInt() % (1024 * 1024 * 100),null);
			}
		}
		
	}
}
