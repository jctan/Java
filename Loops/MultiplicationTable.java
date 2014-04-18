/*
 Name: John Tan
 Course: CIS 4110, Section LMSA
 Programming Assignment #4: Multiplication Table
 Description: Using loops that will output a multiplication table for numbers 1-10. 
 */


public class MultiplicationTable{

    public static void main(String [] args){
        
        
        printLine();
        System.out.println();
        
        for(int row = 1; row <= 10; row++){
            System.out.print("|");
            System.out.print("   " + row + "   ");
        }
        
        System.out.print("\n--------------------------------------------------------------------------------\n");
     
        
        for(int i = 1; i <= 10; i++){
            System.out.print(i + " ");
            for(int j = 1; j <= 10; j++){
                System.out.print("  " + (i*j) + "\t");
            }
                        printLine();
            System.out.println();
        }
        
        System.out.println();
        System.out.println();


    }
    
    public static void printLine(){
        for(int i = 0; i < 20; i++){
            System.out.print("  ");
        }
    }

}