package my.concurrent;

public class NaturalOrderTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		int max = 1000;
		MyLock lock = new MyLock();
		Thread odd = new Thread(new MyOddThread(max,lock));
		Thread even = new Thread(new MyEvenThread(max,lock));
		odd.start();
		even.start();
		even.join();
		odd.join();
		System.out.println("End Of Main");
	}
}
