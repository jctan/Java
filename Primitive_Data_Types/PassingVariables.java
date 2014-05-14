/*
 Name: John Tan
 Course: CIS 4110, Section LMSA
 Programming Assignment #2: Passing Variables
 Description: Write a programsimilar to the second, which handles all type, but the variables must be assigned through parameters. 
 Example:
 
 java PassingVariables  false 0  1 2 3 5.6 7.8

 */



public class PassingVariables{

    public static void main(String [] args){
	
        //Enter the following: java PassingVariables false 0 1 2 3 5.6 7.8
        System.out.println("You have entered the Following:");

        boolean a = Boolean.parseBoolean(args[0]);
        int b = Integer.parseInt(args[1]);
        byte c = Byte.parseByte(args[2]);
        short d = Short.parseShort(args[3]);
        long e = Long.parseLong(args[4]);
        double f = Double.parseDouble(args[5]);
        double g = Double.parseDouble(args[6]);
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        
    }
}