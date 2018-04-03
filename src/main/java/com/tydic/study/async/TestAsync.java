package com.tydic.study.async;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestAsync {
	
	public static void main(String[] args){
		new TestAsync().exec();
	}

	void exec(){
		List<FutureTask<Integer>> futureTasks = new ArrayList<FutureTask<Integer>>();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		long start = System.currentTimeMillis();
		Callable<Integer> callable = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				Integer res = new Random().nextInt(100);
				Thread.sleep(1000);
				System.out.println("任务执行：获取到结果："+res);
				return res;
			}
		};
		
		for(int i=0;i<10;i++){
			FutureTask<Integer> futureTask = new FutureTask<>(callable);
			futureTasks.add(futureTask);
			executorService.execute(futureTask);	
		}
		
		int count = 0;
		for(FutureTask<Integer> futureTask:futureTasks){
			try {
				count= count+futureTask.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		long end = System.currentTimeMillis();
		 System.out.println("线程池的任务全部完成:结果为:"+count+"，main线程关闭，进行线程的清理");
	     System.out.println("使用时间："+(end-start)+"ms");
	     //清理线程池 
	     executorService.shutdown();
	}
	
}
