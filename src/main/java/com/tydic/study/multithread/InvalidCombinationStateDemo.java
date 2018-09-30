package com.tydic.study.multithread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InvalidCombinationStateDemo {
	public static void main(String[] args){
		CombinationStateTask task = new CombinationStateTask();
		Thread thread  = new Thread(task);
		thread.start();
		Random random = new Random();
		Lock lock = new ReentrantLock();
		while(true){
			int rand = random.nextInt(1000);
			//lock.lock(); 
			synchronized(task){
				task.state1 = rand;
				task.state2 = rand*2;
			}
			//lock.unlock();
			
		}
		
	}
	
	private static class CombinationStateTask implements Runnable{
		volatile int state1;
		volatile int state2;
					

		@Override
		public void run() {
			int c = 0;
			for (long i =0;;i++){
				int i1 = state1;
				int i2 = state2;
				if(i1!=i2){
					c++;
					System.err.printf("Fuck! Got invalid CombinationStat!! check time=%s,happen time=%s(%s%%), count value=%s|%s\n"
							,i + 1,c,(float) c / (i+1)*100,i1,i2);
				}else{
					//System.out.printf("Emm....%s|%s\n",i1,i2);
				}
			}
		}
		
	}

}
