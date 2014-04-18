/*
 Name: John Tan
 Course: CIS 4110, Section LMSA
 Programming Assignment #2: Advanced Variables
 Description: Write a program similar to the Simple Declarions, which does the same thing only this time add three more variables for the types mentioned above.
 
 Example:
 java AdvancedVariables
 
 */


public class AdvancedVariables{

    public static void main(String [] args){

        boolean a = true;
        int b = 6; //32 bit
        float c = 7.2f;
        double d = 8.9;
        char e = 'a';
        byte f = 127;//8 bit-type
        short g = 32767;//16 bit-type
        long h  = 1607040000000L; //64 type
        long hexWords = 0xCAFE_BABE;
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(hex);
    }




}