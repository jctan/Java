/*
 Name: John Tan
 Course: CIS 4110, Section LMSA
 Programming Assignment #5: Methods - Math Functions
 Description: 
 Part 1 - 4 functions called multiply, divide, add, and subtract. Each function should take in as a parameter of 2 integers and return an integer.
 Part 2 - If you enter in an invalid number have it return a - 1(Error Condition) then output "Error in Function". Add 4 more functions adddouble, subtractdouble, multipledouble, dividedouble (take in as paramter 2 doubles and return a double). 
 */

public class MathFunctions{

    public static void main (String [] args){


        int a;
        int b;
        int c;
        int d;
        double f;
        double g;
        double h;
        double j;
        
        
        try{
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            
            double xdouble = Double.parseDouble(args[2]);
            double ydouble = Double.parseDouble(args[3]);
            
            int a_insert = add(x,y);
            int b_insert = subtract(x,y);
            int c_insert = multiply(x,y);
            int d_insert = divide(x,y);
            
            double f_insert = adddouble(x,ydouble);
            double g_insert = subtractdouble(x,ydouble);
            double h_insert = multipledouble(x,ydouble);
            double j_insert = dividedouble(x,ydouble);

            a = add(4,5);
            b = subtract(11,6);
            c = multiply(23,3);
            d = divide(25,5);
            
            f = adddouble(4.0,5.0);
            g = subtractdouble(11.0,6.0);
            h = multipledouble(23.0,3.0);
            j = dividedouble(25.0,5.0);
            
            System.out.println("Integer Math Funtions");
            System.out.println("A: " + a);
            System.out.println("B: " + b);
            System.out.println("C: " + c);
            System.out.println("D: " + d);
            
            System.out.println("\nUser Have Entered for Integer:");
            System.out.println("A Entered: " + a_insert);
            System.out.println("B Entered: " + b_insert);
            System.out.println("C Entered: " + c_insert);
            System.out.println("D Entered: " + d_insert);
            
            
            System.out.println("\nDouble Math Functions");
            System.out.println("F: " + f);
            System.out.println("G: " + g);
            System.out.println("H: " + h);
            System.out.println("J: " + j);
            
            System.out.println("\nUser Have Entered for Double:");
            System.out.println("F Entered: " + f_insert);
            System.out.println("G Entered: " + g_insert);
            System.out.println("H Entered: " + h_insert);
            System.out.println("J Entered: " + j_insert);
            

        }
        catch(NumberFormatException e){
            System.out.println("Error in Function");
            return;
        }
     

    }
    
    public static int add(int x, int y){
        int z;
        z = x + y;
        return z;
    }
    
    public static double adddouble(double x, double y){
        double z;
        z = x + y;
        return z;
    }
    
    public static int subtract(int x, int y){
        int z;
        z = x - y;
        return z;
    }
    
    public static double subtractdouble(double x,double y){
        double z;
        z = x - y;
        return z;
    }
    
    public static int multiply(int x, int y){
        int z;
        z = x * y;
        return z;
    }
    
    public static double multipledouble(double x, double y){
        double z;
        z = x * y;
        return z;
    }
    
    public static int divide(int x, int y){
        int z;
        z = x/y;
        return z;
    }
    
    public static double dividedouble(double x, double y){
        double z;
        z = x/y;
        return z;
    }
    

}