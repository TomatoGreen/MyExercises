package my.concurrent;

public class MyOddThread implements Runnable {
	
	int max = 0;
	MyLock lock;
	public MyOddThread(int max,MyLock lock) {
		this.max = max;
		this.lock = lock;
	}
	
	@Override
	public void run() {
		
		try {
			for(int i=1; i<= max; i++){
				
				synchronized (lock) {
					if(lock.isEvenPrint){
						lock.wait();
					}else{
						if(i%2 != 0 ){
							System.out.println(i);
							lock.isEvenPrint = true;
							lock.isOddPrint = false;
							lock.notify();
						}
						
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
