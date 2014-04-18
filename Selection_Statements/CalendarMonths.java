/*
 Name: John Tan
 Course: CIS 4110, Section LMSA
 Programming Assignment #3: Calendar Months
 Description:
 
 It should take as a parameter a single number from 1 - 12
 then output the name of the month corresponding to that number.
 
 for those of you who don't remember
 1 - January  (Enero)
 2- Februrary (Febrero)
 3- March (Marzo)
 4 - April (Abril)
 
 and so on.
 
 If a bad parameter is passed, then you need to tell me its not a valid month.
 */

public class CalendarMonths{

    public static void main(String [] args){

        int month = Integer.parseInt(args[0]);
        String monthString;
        System.out.println("The Month Entered: " + month);
        
        switch(month){
                
            case 1: monthString = "January (Enero)";
                    break;
            case 2: monthString = "February (Febrero)";
                    break;
            case 3: monthString = "March (Marzo)";
                    break;
            case 4: monthString = "April (Abril)";
                    break;
            case 5: monthString = "May (Mayo)";
                    break;
            case 6: monthString = "June (Junio)";
                    break;
            case 7: monthString = "July (Julio)";
                    break;
            case 8: monthString = "August (Agosto)";
                    break;
            case 9: monthString = "September (Septiembre)";
                    break;
            case 10: monthString = "October (Octubre)";
                    break;
            case 11: monthString = "November (Noviembre)";
                    break;
            case 12: monthString = "December (Diciembre)";
                    break;
            default: monthString = "Invalid Month";
                    break;
        }
        System.out.println("The Month " + month + " is " + monthString);
        
    }
}