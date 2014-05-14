
package threads.diningphilosophers;

public class Philosopher extends Thread{
	
	private Chopstick leftChopstick;
	private Chopstick rightChopstick;
	private String name;
	
	private long eatCount = 0;
	private long totalWait;
	private long waitStart; 
	private long waitStop;
	
	public long getNumberOfMeals(){
		return eatCount;
	}
	
	public long getWaitTime(){
		return totalWait;
	}
	
	public Philosopher(String name){
		super(name);
	}
	
	
	public void run(){
		
		//while(true){
			//not hungry - waiting
			Logger.printOut(getName() + " is waiting.");
			waiting();
			
			System.out.println("");
			
			//hungry - pick up chopstick
			Logger.printOut(getName() + " is hungry.");

			Logger.printOut(getName() + " grabs left chopstick.");
			leftChopstick.grab(this);
	
			Logger.printOut(getName() + " grabs right chopstick.");
			rightChopstick.grab(this);
			
			//hungry - eating
			Logger.printOut(getName() + " is eating.");
			eating();
			Logger.printOut(getName() + " finished eating.");
			
			//finished eating - release chopstick
			Logger.printOut(getName() + " drops left chopstick.");
			leftChopstick.drop(this);
			
			Logger.printOut(getName() + " drops right chopstick.");
			rightChopstick.drop(this);
			
			
			Logger.printOut(getName() + " WAITED " + getWaitTime() + " Times ");
			Logger.printOut(getName() + " ATE " + getNumberOfMeals() + " Meals ");
			
			System.out.println("");

			
		//}
		
			
	}




	private void eating(){
		waitStop = System.currentTimeMillis();
		totalWait += waitStop - waitStart;
		eatCount++;
		
		RandomWait.waitRandom();
		
	}
	
	private void waiting(){
		waitStart = System.currentTimeMillis();
		
		RandomWait.waitRandom();
	}


	public void setLeftChopstick(Chopstick leftChopstick) {
		this.leftChopstick = leftChopstick;
	}


	public void setRightChopstick(Chopstick rightChopstick) {
		this.rightChopstick = rightChopstick;
	}
	
	

}
