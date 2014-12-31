package my.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue<String> queue = null;
	private int loopCount = 0;
	
	public Consumer(BlockingQueue<String> queue, int loopCount){
		this.queue = queue;
		this.loopCount = loopCount;
	}
	
	@Override
	public void run() {
		try{
			while(loopCount>0 && queue!=null){
				System.out.println(queue.take());
				loopCount--;
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}

	}
}
