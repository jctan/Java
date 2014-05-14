/*
 Name: John Tan
 Course: CIS 4110, Section LMSA
 Programming Assignment #5: Array - Basic Array
 Description: Program ask user for the name of the month given an index. The user should enter the name of the month for the given prompt. Store the response into an array and then display the array in reverse order.
 */

import java.util.*;

public class CalendarInput{

    public static void main(String [] args){

        
        Scanner input = new Scanner(System.in);
        
        String months;
        String [] ListMonths = new String [12];
        
        int numWords_index = 0;
        
        for(int i = 1; i <= 12; i++){
            System.out.println("\nEnter Month #" + i + ": ");
            months = input.nextLine();
            ListMonths[numWords_index] = months;
            numWords_index++;
        }
        
        System.out.println("\nThe months you have entered: ");
        for(int i = 0; i<numWords_index; i++){
            System.out.println(ListMonths[i]);
        }
        
        System.out.println("\nThe months in reversed order: ");
        for(int i = numWords_index-1; i >=0; i--){
        System.out.println(ListMonths[i]);
        }


	}
}