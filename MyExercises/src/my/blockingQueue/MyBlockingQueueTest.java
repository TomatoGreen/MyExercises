package my.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyBlockingQueueTest {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
		Producer producer = new Producer(queue, 3);
		Consumer consumer = new Consumer(queue, 3);
		
		(new Thread(producer)).start();
		(new Thread(consumer)).start();
	}

}
