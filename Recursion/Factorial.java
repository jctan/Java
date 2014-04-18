import javax.swing.*;

public class Factorial{

    public static void main(String [] args){
        
        //input (default frame)
        String str = JOptionPane.showInputDialog(null,"Enter a number");
        int number = Integer.parseInt(str); //for reading integers

        int result = factorial(number);
        
        //output (default frame)
        JOptionPane.showMessageDialog(null,"The factorial of " + number + " is " + result);



    }
    
    public static int factorial(int number){
        
        if(number <= 1){
            return 1;
        }
        else{
            return number * factorial(number-1);
        }
        
    }

}