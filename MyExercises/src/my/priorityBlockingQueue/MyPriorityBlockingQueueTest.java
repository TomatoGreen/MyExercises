package my.priorityBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class MyPriorityBlockingQueueTest {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new PriorityBlockingQueue<Integer>();
		PriorityBlockingQueueProducer producer = new PriorityBlockingQueueProducer(queue, 50);
		PriorityBlockingQueueConsumer consumer = new PriorityBlockingQueueConsumer(queue, 50);
		
		Thread t1 = new Thread(producer, "producerThread");
		Thread t2 = new Thread(consumer, "consumerThread");
		
		t1.start();
		try{
			t1.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		t2.start();
	}
}
