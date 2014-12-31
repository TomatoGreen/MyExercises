package my.exchanger;

import java.util.concurrent.Exchanger;

public class TestExchanger {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger();
		ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "A");
		ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");
		
		new Thread(exchangerRunnable1, "Thread_1").start();
		new Thread(exchangerRunnable2, "Thread_2").start();
	}
}
