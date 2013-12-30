/*
Name: John Tan 
Assignment #1 (Java Basic) - Days
Date: 9/27/2013
*/

import java.util.*;

public class Days {
	
	public static void main(String[] args) {

        String month; 
        
        System.out.println("java Days");
        System.out.println("----------------");
        
        System.out.print("Enter the month: ");
        Scanner inputScanner = new Scanner(System.in);
        month = inputScanner.next();
        
        int returned_monthNum =
            Days.getmonthNum(month);

        if (returned_monthNum == 0) {
            System.out.println("Invalid month");
        } 
        System.out.println(month + " is month number " + returned_monthNum);
        
        int year = 2013;
        int numDays = 0;
        
        switch(month){
        case "JAN":
        case "january":
        case "MAR":
        case "march":
        case "MAY":
        case "may":
        case "JUL":
        case "july":
        case "AUG":
        case "august":
        case "OCT":
        case "october":
        case "DEC":
        case "december":
        	numDays = 31; 
        	break;
        case "APR":
        case "april":
        case "JUNE":
        case "june":
        case "SEPT":
        case "september":
        case "NOV":
        case "november":
        	numDays = 30;
        	break;
        case "FEB":
        case "february":
        	if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
        		numDays = 29;
        	else 
        		numDays = 28;
        	break;
        default:
        	System.out.println("Invalid month.");
        	break;
        }
        System.out.println("It has " + numDays + " days.");
      
    }

	public static int getmonthNum(String month) {

        int monthNum = 0;

        if (month == null) {
            return monthNum;
        }

        switch (month) {
            case "JAN":
            case "january":
            	monthNum = 1;
                break;
            case "FEB":
            case "february":
            	monthNum = 2;
                break;
            case "MAR":
            case "march":
            	monthNum = 3;
                break;
            case "APR":
            case "april":
            	monthNum = 4;
                break;
            case "MAY":
            case "may":
            	monthNum = 5;
                break;
            case "JUNE":
            case "june":
            	monthNum = 6;
                break;
            case "JUL":
            case "july":
            	monthNum = 7;
                break;
            case "AUG":
            case "august":
            	monthNum = 8;
                break;
            case "SEPT":
            case "september":
            	monthNum = 9;
                break;
            case "OCT":
            case "october":
            	monthNum = 10;
                break;
            case "NOV":
            case "november":
            	monthNum = 11;
                break;
            case "DEC":
            case "december":
            	monthNum = 12;
                break;
            default: 
            	monthNum = 0;
                break;
        }

        return monthNum;
    }


}
