/*
Name: John Tan 
Assignment #2 - Java OOP 
Date: 9/27/2013

Features: ChangeRevolver will call methods from MakeChange and CountChange
		  The user have the option to chose to MakeChange ("M") or CountChange ("C").
		  If user doesn't enter "M" or "C", it will return back to the loop and ask user to 
		  enter again. After user enters either of the options, it will prompt the 
		  user to exit by pressing "X"

 */

import java.util.*;

public class ChangeRevolver{

	public static void main(String[] args) {
		
		//Scanner to enter M and C 
		Scanner input = new Scanner(System.in);
		//Scanner to enter X
		Scanner valid = new Scanner(System.in);
		boolean run = true;
			
			//loop that ask user to enter again if it's invalid
			while(run){
				System.out.println("Would you like to MakeCahnge or CountChange? ");
				System.out.println("---------------------------------------------------");
				System.out.println("[Press M - MakeChange] | [Press C - CountChange]: ");
		
				String str = input.nextLine().toUpperCase();
				if(str.equals("C")){
				//calling the CountChange Method
				CountChange countchange = new CountChange();
		
				System.out.print("Enter the number of Quarters: ");
				int quarters = input.nextInt();

		
				System.out.print("Enter the number of Dimes: ");
				int dimes = input.nextInt();

				System.out.print("Enter the number of Nickles: ");
				int nickles = input.nextInt();

				System.out.print("Enter the number of Pennies: ");
				int pennies = input.nextInt();
				//sets to the variable in setCoins methods from CountChange
				countchange.setCoins(quarters, dimes, nickles, pennies);
		
				double total = countchange.getTotal(); 
				System.out.println("Total: $" + total);
				System.out.println("Thank you");
				System.out.println("\n---------------------------------------------------\n");
				System.out.println("[Press X to Exit Program]: ");
				String str1 = valid.nextLine().toUpperCase();
				if(str1.equals("X")){
					//user enters X to exit the program
				System.exit(0);
				}
				
				}
				else if(str.equals("M")){
					//Calling the MakeChange Method
					MakeChange makechange = new MakeChange(); 
				
					System.out.print("Enter a sum of money in cents: ");
					double total_amt = input.nextDouble(); 
					//sets to the variable in setTotalAmount from MakeChange
					makechange.setTotalAmount(total_amt);
				
					int Quarters = makechange.getQuarters();
					System.out.println("Quarters: " + Quarters);
				
					int Dimes = makechange.getDimes();
					System.out.println("Dimes: " + Dimes);
				
					int Nickles = makechange.getNickles();
					System.out.println("Nickles: " + Nickles);
				
					int Pennies = makechange.getPennies();
					System.out.println("Pennies: " + Pennies);
					System.out.println("Thank you");
					System.out.println("\n---------------------------------------------------\n");
					System.out.println("[Press X to Exit Program]");
					String str1 = valid.nextLine().toUpperCase();
						if(str1.equals("X")){
							//user enters X to exit the program
							System.exit(0);
						}
					}
				else{
					System.out.println("Invalid Input!");
					System.out.println("Please Try Again!");
					System.out.println("\n---------------------------------------------------\n");
					if(!(str.equals("M") || str.equals("C")))
					{
						continue; 
					}
					}
			}
		
			}
			}

