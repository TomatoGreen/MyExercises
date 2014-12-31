package my.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
	public static void main(String[] args) {
		CyclicBarrier barrier1 = new CyclicBarrier(2, new BarrierAction("Barrier1Action"));
		CyclicBarrier barrier2 = new CyclicBarrier(2, new BarrierAction("Barrier2Action"));
		
		CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(barrier1, barrier2);
		CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(barrier1, barrier2);
		new Thread(barrierRunnable1).start();
		new Thread(barrierRunnable2).start();
	}
}
