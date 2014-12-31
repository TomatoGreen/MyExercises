package my.delayQueue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class DelayQueueProducer implements Runnable {
	private BlockingQueue<DelayElement> queue = null;
	private int loopCount = 0;
	private Random random = new Random();
	
	public DelayQueueProducer(BlockingQueue<DelayElement> queue, int loopCount){
		this.queue = queue;
		this.loopCount = loopCount;
	}
	@Override
	public void run() {
		try{
			while(loopCount>0 && queue!=null){
				int delay = random.nextInt(10000);
				queue.put(new DelayElement(String.valueOf(delay), delay));
				loopCount--;
				Thread.sleep(500);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
