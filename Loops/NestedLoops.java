/*
 Name: John Tan
 Course: CIS 4110, Section LMSA
 Programming Assignment #4: Multiple Loops
 Description: You must pass in 2 parameters into a public class NestedLoops. The program should iterate (loop) through each number so if the 2 argument (3,5). you should have an outer loop 10 times and an inner loop (inside the outerloop) 5 times, and output a counter variable inside the inner loop.
 */

public class NestedLoops{

    public static void main(String [] args){
        
        
        int counter = 1;
        
        for(int x = Integer.parseInt(args[0]); x <= 10; x++){
            for(int y = Integer.parseInt(args[1]); y <= 5; y++){
                System.out.println("x: " + x + " y: " + y + " (" + counter + ")");
                counter++;
            }
        }

    }

}