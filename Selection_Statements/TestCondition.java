/*
 Name: John Tan
 Course: CIS 4110, Section LMSA
 Programming Assignment #3: Test Condition
 Description:
 This class should take in two variables (passed as arguments)
 
 it should test to see which is bigger and say one of the three following things
 
 "First Parameter is larger than the Second"
 
 or
 
 "Second Parameter is larger than the first"
 
 or
 
 "The parameters are equal"
 */


public class TestCondition{

    public static void main(String [] args){

    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);

        System.out.println("First Parameter Entered: " + a);
        System.out.println("Second Parameter Entered: " + b);

    if(a > b){
    System.out.println("First Parameter is larger than the Second");
    }

    if(a < b){
    System.out.println("Second Parameter is larger than the First");
    }

    if(a == b){
    System.out.println("The Parameters are equal");
    }


    }
}