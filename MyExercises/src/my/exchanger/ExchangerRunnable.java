/**
 * 
 */
package my.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author Zhenzhen
 *
 */
public class ExchangerRunnable implements Runnable {

	private Exchanger<String> exchanger = null;
	private String object  = null;
	
	public ExchangerRunnable(Exchanger<String> exchanger, String object){
		this.exchanger = exchanger;
		this.object = object;
	}
	
	@Override
	public void run() {
		try{
			String previous = this.object;
			this.object = this.exchanger.exchange(this.object);
			
			System.out.println(Thread.currentThread().getName() + " exchanged " + previous + " for " + this.object);
		}catch(InterruptedException e){
			e.printStackTrace();
		}

	}


}
