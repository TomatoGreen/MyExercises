/**
 * 
 */
package my.cyclicBarrier;

/**
 * @author Zhenzhen
 *
 */
public class BarrierAction implements Runnable {

	private String name;
	
	public BarrierAction(String name){
		this.name=name;
	}
	
	@Override
	public void run() {
		System.out.println(name + " executed.");
	}

}
