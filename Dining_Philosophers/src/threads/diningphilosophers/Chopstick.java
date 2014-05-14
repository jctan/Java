package threads.diningphilosophers;

import java.util.concurrent.locks.Lock;

public class Chopstick {
	
	
	private Philosopher reservedBy; 
	private Philosopher grabbedBy;

	//pick up chopstick (only one thread pick up one at a time)
	public synchronized void grab(Philosopher philosopher) {
		
		//if chopstick is not pickedup
		if(grabbedBy != null){
			
			if(philosopher != grabbedBy){
				this.reserve(philosopher);
			}
		}
		else{
			this.grabbedBy = philosopher;
		}
		
	}

	//prevent from deadlock 
	private synchronized void reserve(Philosopher philosopher) {
		
		this.reservedBy = philosopher; 
		
		try {
			Logger.printOut(philosopher.getName() + " is waiting on a chopstick.");
			this.wait();
			Logger.printOut(philosopher.getName() + " recieved a chopstick");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.reservedBy = null;
		
		this.grab(philosopher);
		
	}
	
	//put down the chopstick 
	public synchronized void drop(Philosopher philosopher) {
		
		this.grabbedBy = null;
		
		if(this.reservedBy != null){
			//notify all thread which chopstick is released 
			this.notifyAll();
		}
		
	}
	

}
