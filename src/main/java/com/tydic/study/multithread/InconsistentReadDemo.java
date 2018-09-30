package com.tydic.study.multithread;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InconsistentReadDemo {
	volatile int  count=1;
	Lock lock = new ReentrantLock();
	AtomicReference<int[]> atomic = new AtomicReference<int[]>();

	
	public static void main(String[] args){
		InconsistentReadDemo demo = new InconsistentReadDemo();
		Thread thread = new Thread(demo.getConcurrencyCheckTask());
		thread.start();
		demo.atomic.set(new int[]{1});
		while (true){
			//demo.lock.lock();
			//demo.count++;
			int[] numbers = demo.atomic.get();
	        numbers[0]++;
	        //demo.atomic.compareAndSet(numbers, numbers);
	        //success++;
	        //success 
			//demo.lock.unlock();
		}
				
			
		
	}
	
	
	ConcurrencyCheckTask getConcurrencyCheckTask(){
		return new ConcurrencyCheckTask();
	}
	
	private class ConcurrencyCheckTask implements Runnable{

		@Override
		public void run() {
			int c = 0;
			for(int i=0;;i++){
				int c1,c2=0;
				//lock.lock();
				//c1 = count;
				//c2 = count;
				c1 = atomic.get()[0];
				c2 = atomic.get()[0];
				//lock.unlock();
				if(c1!=c2){
					c++;
					// 我的开发机上，进程启动时可以观察到一批不一致读
                    System.err.printf("Fuck! Got inconsistent read!! check time=%s, happen time=%s(%s%%), 1=%s, 2=%s\n",
                            i + 1, c, (float) c / (i + 1) * 100, c1, c2);
				}else{
					System.out.printf("coreectt.......\n");
				}
			}
			
		}
		
	}

}
