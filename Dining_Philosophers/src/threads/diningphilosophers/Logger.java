package threads.diningphilosophers;

public class Logger {
	
	public static synchronized void printOut(String text){
		
		System.out.println(text);
		
	}

}
