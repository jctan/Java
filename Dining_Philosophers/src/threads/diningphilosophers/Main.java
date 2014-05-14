package threads.diningphilosophers;

public class Main {

	public static void main(String[] args) {
		
		Philosopher John = new Philosopher("John");
		Chopstick c1 = new Chopstick();
		
		Philosopher Bryan = new Philosopher("Bryan");
		Chopstick c2 = new Chopstick();
		
		Philosopher Danny = new Philosopher("Danny");
		Chopstick c3 = new Chopstick();
		
		Philosopher Wendy = new Philosopher("Wendy");
		Chopstick c4 = new Chopstick();
		
		Philosopher Winston = new Philosopher("Winston");
		Chopstick c5 = new Chopstick();
		
		John.setLeftChopstick(c5);
		John.setRightChopstick(c1);
		
		Bryan.setLeftChopstick(c1);
		Bryan.setRightChopstick(c2);

		Danny.setLeftChopstick(c2);
		Danny.setRightChopstick(c3);
		
		Wendy.setLeftChopstick(c3);
		Wendy.setRightChopstick(c4);
		
		Winston.setLeftChopstick(c4);
		Winston.setRightChopstick(c5);
		
		John.start();
		Bryan.start();
		Danny.start();
		Wendy.start();
		Winston.start();

	}

}
