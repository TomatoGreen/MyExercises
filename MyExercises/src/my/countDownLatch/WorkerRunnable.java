/**
 * 
 */
package my.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Zhenzhen
 *
 */
public class WorkerRunnable implements Runnable {

	private CountDownLatch startLatch;
	private CountDownLatch stopLatch;
	private String name;
	
	public WorkerRunnable(CountDownLatch startLatch, CountDownLatch stopLatch, String name){
		this.startLatch = startLatch;
		this.stopLatch = stopLatch;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try{
			startLatch.await();//wait until the latch has count down to zero
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Running: " + name);
		stopLatch.countDown();
	}

}
