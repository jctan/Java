public class SimpleStringWork{

    public static void main(String[] args){
        
        int input;
        int length;
        

        for(input = 0; input < args.length; input++){
            System.out.println("\nYou have entered: " + args[input]);
            
            length = args[input].length();
            System.out.println("The first character of the String is: " + args[input].charAt(0));
            System.out.println("The last character of the String is: " + args[input].charAt(length-1));
            System.out.println("The length of the String is: " + length);
            System.out.println("The first 3 characters of the string is: " + args[input].substring(0,3) + "\n");
        }
        
        
        StringBuffer sb = new StringBuffer();
        
        sb.append(args[0]);
        sb.append(args[1]);
        sb.append(args[2]);
        sb.reverse();
        
        System.out.println("The character in reverse order is: " + sb.toString());

    }
}