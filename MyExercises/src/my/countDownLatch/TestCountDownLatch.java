package my.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
	public static void main(String[] args) {
		int count = 10;
		CountDownLatch startLatch = new CountDownLatch(1);
		CountDownLatch stopLatch = new CountDownLatch(count);
		
		for(int i=0; i<count; i++){
			new Thread(new WorkerRunnable(startLatch, stopLatch, ("Thread_" + i))).start();
		}
		System.out.println("GO");
		startLatch.countDown();
		try{
			stopLatch.await();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("DONE");
	}
}
