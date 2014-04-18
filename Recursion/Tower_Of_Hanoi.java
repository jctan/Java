import java.util.*;

public class Tower_Of_Hanoi{

    public static void main(String [] args){
        
        
        Scanner input = new Scanner(System.in);
        int num;
        System.out.println("Enter the number of disk: ");
        num = input.nextInt();
        
        moveTower(num, "A", "B", "C");


    }
    
    
    public static void moveTower(int diskNum, String a, String b, String c){
        
       final String directMove = "Disk " + diskNum + " from " + a + " to " + c;
        
        if(diskNum <= 0){
            return;
        }
        
        if(diskNum > 0){
            moveTower(diskNum-1,a,c,b); //move disk from A - B
            System.out.println(directMove);
            moveTower(diskNum-1,b,a,c); //move disk form B - C
            
        }
    
    }

}