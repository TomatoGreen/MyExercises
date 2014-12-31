package my.priorityBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class PriorityBlockingQueueProducer implements Runnable {
	private BlockingQueue<Integer> queue = null;
	private int loopCount = 0;
	
	public PriorityBlockingQueueProducer(BlockingQueue<Integer> queue, int loopCount){
		this.queue = queue;
		this.loopCount = loopCount;
	}
	@Override
	public void run() {
		try{
			while(loopCount>0 && queue!=null){
				queue.put(ThreadLocalRandom.current().nextInt(0, 1000));
				loopCount--;
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
