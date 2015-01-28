package my.blockingQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zhenzhen
 *
 */
public class BlockingQueueImp2 {
	private Condition isFull;
	private Condition isEmpty;
	private Lock lock;
	private int limit = 0;
	private List<String> queue = new LinkedList<String>();
	
	public BlockingQueueImp2(){
		this(Integer.MAX_VALUE);
	}
	public BlockingQueueImp2(int limit){
		this.limit = limit;
		lock = new ReentrantLock();
		isFull = lock.newCondition();
		isEmpty = lock.newCondition();
	}
	
	public void put(String o) throws InterruptedException{
		lock.lock();
		try{
			while(this.queue.size()==this.limit){
				isFull.await();
			}
			isEmpty.signalAll();
			queue.add(o);
		}catch(InterruptedException e){
			throw new InterruptedException(e.getMessage());
		}finally{
			lock.unlock();
		}
	}
	
	public String get() throws InterruptedException{
		String o = null;
		lock.lock();
		try{
			while(this.queue.size()==0){
				isEmpty.await();
			}
			isFull.signalAll();
			o = queue.remove(0);
		}catch(InterruptedException e){
			throw new InterruptedException(e.getMessage());
		}finally{
			lock.unlock();
		}
		return o;
	}
}
