package my.delayQueue;

import java.util.concurrent.BlockingQueue;

public class DelayQueueConsumer implements Runnable {
	private BlockingQueue<DelayElement> queue = null;
	private int loopCount = 0;
	
	public DelayQueueConsumer(BlockingQueue<DelayElement> queue, int loopCount){
		this.queue = queue;
		this.loopCount = loopCount;
	}
	
	@Override
	public void run() {
		try{
			while(loopCount>0 && queue!=null){
				System.out.println(Thread.currentThread().getName() + queue.take().toString());
				loopCount--;
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}

	}
}
