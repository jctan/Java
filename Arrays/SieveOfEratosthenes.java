]
/*
 Name: John Tan
 Course: CIS 4110, Section LMSA
 Programming Assignment #5: Array - Sieve Of Eratothenes (Prime Numbers)
 Description: The sieve of eratothenes is a program that will determine prime numbers. Look up how the Sieve of Erasthones works , and get the program to output the total number of primes (and list them) up to 1000.
 */

import java.util.*;

public class SieveOfEratosthenes{

    public static void main(String [] args){

        int num;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the prime number limit: \n");
        num = input.nextInt();
        input.close();
        
        
        boolean [] isPrime = new boolean[num];
        isPrime[0] = false;
        for(int i = 1; i < num; i++){
            isPrime[i] = true;
        }
        
        
        for(int i = 2; i <= num; i++){
            if(isPrime[i-1]){
                System.out.println(i);
                
                for(int j = i * i; j <= num; j = j + i){
                    isPrime[j-1] = false;
                }
                
            }
        }


    }
}