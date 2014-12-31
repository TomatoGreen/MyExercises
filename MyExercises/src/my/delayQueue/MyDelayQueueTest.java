package my.delayQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class MyDelayQueueTest {

	public static void main(String[] args) {
		BlockingQueue<DelayElement> queue = new DelayQueue<DelayElement>();
		
		(new Thread(new DelayQueueProducer(queue, 10))).start();
		(new Thread(new DelayQueueConsumer(queue, 5), "Consumer_Thread1")).start();
		(new Thread(new DelayQueueConsumer(queue, 5), "Consumer_Thread2")).start();
	}

}
