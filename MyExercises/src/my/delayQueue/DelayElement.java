package my.delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayElement implements Delayed {
	private String data = null;
	private long startTime = 0;
	
	public DelayElement(String data, long delayTime){
		this.data=data;
		this.startTime = System.currentTimeMillis()+delayTime;
	}
	
	@Override
	public int compareTo(Delayed arg0) {
		if(startTime < ((DelayElement)arg0).getStartTime())
			return -1;
		else if(startTime > ((DelayElement)arg0).getStartTime())
			return 1;
		else
			return 0;
	}

	@Override
	public long getDelay(TimeUnit arg0) {
		long diff = startTime-System.currentTimeMillis();
		return arg0.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String getData() {
		return data;
	}

	public long getStartTime() {
		return startTime;
	}

	@Override
	public String toString(){
		String ret = "{data='" + data + "\', startTime=" + startTime +"}";
		return ret;
	}
}
