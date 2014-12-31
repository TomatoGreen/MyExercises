package my.priorityBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class PriorityBlockingQueueConsumer implements Runnable {
	private BlockingQueue<Integer> queue = null;
	private int loopCount = 0;
	
	public PriorityBlockingQueueConsumer(BlockingQueue<Integer> queue, int loopCount){
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
