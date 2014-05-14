import java.util.Scanner;

/*----------------------------------------------------------------------------------------------------------------------------*/

/*
Name: John Tan 
Assignment #2 - Java OOP 
Date: 9/27/2013

 */

/*These methods for CountChange are called from ChangeRevolver.java */

public class CountChange{	
	
	//private variables for CountChange
	private int quarters, dimes, nickles, pennies;
	private double tot; 
	
	//setCoins for user input
	public void setCoins(int quarters, int dimes, int nickles, int pennies){
		this.quarters = quarters;
		this.dimes = dimes; 
		this.nickles = nickles; 
		this.pennies = pennies;
	}
	
	//returns quarters from user input
	public int getQuarters(){
		return quarters;
	}	
	
	//returns dimes from user input
	public int getDimes(){
		return dimes;
	}
	
	////returns nickels from user input
	public int getNickles(){
		return nickles;
	}
	
	//returns pennies from user input
	public int getPennies(){
		return pennies;
	}
	
	//return to the total of CountChange
	public double getTotal(){
		tot = ((0.25*quarters) + (0.10*dimes) + (0.05*nickles) + (0.01*pennies));
		return tot;
	}

	
	public static void main(String[] args) 
	{
		double total = 0.0;
		
		Scanner input = new Scanner(System.in);
		
		//Asks the user for the amount of coins
		System.out.print("Enter the number of quarters: ");
		int quarters = input.nextInt();
		
		System.out.print("Enter the number of dimes: ");
		int dimes = input.nextInt();
		
		System.out.print("Enter the number of nickels: ");
		int nickels = input.nextInt();
		
		System.out.print("Enter the number of pennies: ");
		int pennies = input.nextInt();
		
		//Calculates the total amount of the coins the user inputed
		total = (0.25*quarters) + (0.10*dimes) + (0.05*nickels) + (0.01*pennies);
		
		//Prints out the total amount
		System.out.println("Total: $" + total);
		System.out.println("Thank you");
	}

}

