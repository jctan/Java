/*
 Name: John Tan
 Course: CIS 4110, Section LMSA
 Programming Assignment #4: Conditions
 Description: Incrementment (add 1) a variable called x 10 times (Note: Start x at 0). Then multiple it by 2 ten times (using a diffeerent loop statement). Then subtract 5 ten times (also using a different loop). Then output the final answer will be 10190.
 */

public class Conditional{

    public static void main(String [] args){

        int x = 0;
        int increment1 = 0;
        int increment2 = 0;
        
        System.out.println("\nFor Loop:");
        
        for(x = 0; x < 10; x++){
            System.out.println(x);
        }
        
        System.out.println("\nWhile Loop:");
        
        while(increment1 < 10){
            x = x * 2;
            increment1++;
            System.out.println(x);
        }
        System.out.println("\nDo While Loop:");
        
        do{
            x = x - 5;
            increment2++;
            System.out.println(x);
        }while(increment2 < 10);
        
        System.out.println("\nThe output of the final answer is: " + x);
        

    }
}