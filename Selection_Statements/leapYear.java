/*
 Name: John Tan
 Course: CIS 4110, Section LMSA
 Programming Assignment #3: Leap Year
 Description:
 
 The program should take 3 parameters:
 first one - month
 second one - day
 third one - year.
 
 First: Have the program output the day of the week
 (for example if I enter 02 26 2009)
 the output should be :
 
 Thursday - February 26, 2009.
 
 Right after that it should say whether or not 2009 is a leap year,
 and if there is less than 60 days left in that year output how many days are left in that year.
 
 So the output would really look like
 
 Thursday - February 26, 2009 .
 2009 is not a leap year.
 There are 308 days left in the year.

 */

import java.util.*;
import java.text.SimpleDateFormat;

public class leapYear{

    public static void main(String [] args){

        
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        int year = Integer.parseInt(args[2]);
        
        
        Calendar cal = new GregorianCalendar();
        
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_MONTH, day);
        
        
        //0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday, 4 = Thursday, 5 = Friday, 6 = Saturday.
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK);

        String dayString = "";
        
        if(Calendar.SUNDAY == day_of_week){
            dayString = "Sunday";
        }
        else if(Calendar.MONDAY == day_of_week){
            dayString = "Monday";
        }
        else if(Calendar.TUESDAY == day_of_week){
            dayString = "Tuesday";
        }
        else if(Calendar.WEDNESDAY == day_of_week){
            dayString = "Wednesday";
        }
        else if(Calendar.THURSDAY == day_of_week){
            dayString = "Thursday";
        }
        else if(Calendar.FRIDAY == day_of_week){
            dayString = "Friday";
        }
        else if(Calendar.SATURDAY == day_of_week){
            dayString = "Saturday";
        }
    
 
    
        String monthString;
        switch(month){
            case 1: monthString = "January";
                break;
            case 2: monthString = "February";
                break;
            case 3: monthString = "March";
                break;
            case 4: monthString = "April";
                break;
            case 5: monthString = "May";
                break;
            case 6: monthString = "June";
                break;
            case 7: monthString = "July";
                break;
            case 8: monthString = "August";
                break;
            case 9: monthString = "September";
                break;
            case 10: monthString = "October";
                break;
            case 11: monthString = "November";
                break;
            case 12: monthString = "December";
                break;
            default: monthString = "Invalid Month";
                break;
        }
    
        
        if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)){
            System.out.println(year + " is a leap year");
        }
        else{
            System.out.println(year + " is not a leap year");
        }

        
        System.out.println(dayString + " - " + monthString + " " + day + ", " + year);
        


        String dateStr = day + "/" + month + "/" + year;
        
        
        try{
         
        Date format = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
        }
        catch(Exception e){
            e.printStackTrace(); //default error exception
        }
        
        int [] days_in_each_month = {31,28,31,30,31,30,31,31,30,31,30,31};
        int days_left = 0;
        
        for(int i = 12; i > month; i--){
            days_left = days_left + days_in_each_month[i-1];
        }
        
        days_left = days_left + (days_in_each_month[month - 1] - day);
        
        System.out.println("There are " + days_left + " days left in the year");
    
        
                           
    }
    
    

}