package my.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private BlockingQueue<String> queue = null;
	private int loopCount = 0;
	
	public Producer(BlockingQueue<String> queue, int loopCount){
		this.queue = queue;
		this.loopCount = loopCount;
	}
	
	@Override
	public void run() {
		try{
			while(loopCount>0 && queue!=null){
				queue.put(String.valueOf(loopCount));
				loopCount--;
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
