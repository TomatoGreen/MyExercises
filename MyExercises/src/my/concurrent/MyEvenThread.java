package my.concurrent;

public class MyEvenThread implements Runnable {
	
	int max = 0;
	MyLock lock;
	public MyEvenThread(int max,MyLock lock) {
		this.max = max;
		this.lock = lock;
	}
	
	@Override
	public void run() {
		try {
			for(int i=2; i<= max; i++){
				synchronized (lock) {
					if(lock.isOddPrint){
						lock.wait();
					}else{
						if(i%2 == 0 ){
							System.out.println(i);
							lock.isOddPrint = true;
							lock.isEvenPrint = false;
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
