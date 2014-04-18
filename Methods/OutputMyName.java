/*
 Name: John Tan
 Course: CIS 4110, Section LMSA
 Programming Assignment #5: Methods - OutputName
 Description: The program has 2 methods main (the normal one you must have) and another one called outputname which takes one parameter (a string) and has no return value. 
 */

public class OutputMyName{

    public static void main(String [] args) {

        outputname("Alex");
        outputname("David Weight");
        outputname("Derek Jeter");

    }
    
    
    public static void outputname(String str){
        System.out.println(str);
    }

}