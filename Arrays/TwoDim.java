/*
 Name: John Tan
 Course: CIS 4110, Section LMSA
 Programming Assignment #5: Array - 2 Dimensional Array
 Description: populate the array with consecutive values in 2D Array. Then display in a grid format the contents of the array.
 */

public class TwoDim{

    public static void main(String [] args){
        
        
        final int ROWS = 20;
        final int COLUMNS = 20;
        int arr[][] = new int [ROWS][COLUMNS];

        
        int sum = 1;
        for(int i = 0; i < ROWS ; i++){
            System.out.println();
            for(int j = 0; j < COLUMNS ;j++){
                sum = sum + arr[i][j];
                System.out.printf("%4d", sum );
                sum++;
            }
        }
        System.out.println("\n");


    }

}