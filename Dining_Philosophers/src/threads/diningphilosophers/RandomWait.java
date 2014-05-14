package threads.diningphilosophers;

import java.util.Random;

public class RandomWait {
	
	private static Random random = new Random();
	
	//2 threads or more cannot access this method simultaneously (only 1 thread can access at the same time)
	public static synchronized void waitRandom(){
		
		int millis = (int) (random.nextDouble() * 100);
		
		try{
			
			Thread.sleep(millis);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}


}
