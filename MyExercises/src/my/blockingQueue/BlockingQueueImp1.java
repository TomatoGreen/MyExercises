package my.blockingQueue;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhenzhen
 *
 */
public class BlockingQueueImp1 {
	private List<String> queue = new LinkedList<String>();
	private int limit=10;
	public BlockingQueueImp1(int limit){
		this.limit = limit;
	}
	
	public synchronized void enqueue(String item) throws InterruptedException{
		while(this.queue.size()==this.limit){
			wait();
		}
		if(this.queue.size()==0){
			notifyAll();
		}
		this.queue.add(item);
	}
	
	public synchronized String dequeue() throws InterruptedException{
		while(this.queue.size()==0){
			wait();
		}
		if(this.queue.size()==this.limit){
			notifyAll();
		}
		return this.queue.remove(0);
	}
}
