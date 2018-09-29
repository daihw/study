package com.tydic.study.multithread;

public class InconsistentReadDemo {
	int count=1;
	
	public static void main(String[] args){
		InconsistentReadDemo demo = new InconsistentReadDemo();
		Thread thread = new Thread(demo.getConcurrencyCheckTask());
		thread.start();
		while (true){
			demo.count++;
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
				int c1 = count;
				int c2 = count;
				if(c1!=c2){
					c++;
					// �ҵĿ������ϣ���������ʱ���Թ۲쵽һ����һ�¶�
                    System.err.printf("Fuck! Got inconsistent read!! check time=%s, happen time=%s(%s%%), 1=%s, 2=%s\n",
                            i + 1, c, (float) c / (i + 1) * 100, c1, c2);
				}
			}
			
		}
		
	}

}