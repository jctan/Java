import java.io.*;
import java.util.*;

class FileClass{


    public static void main(String[] args){
        
        System.out.println("Read from file: ");
        System.out.println(readFile());
        
        System.out.println("Write from file: ");
        writeFile();
    }
    
    
    public static String readFile(){
        
        StringBuffer sb = new StringBuffer();

        try{
            
            String inputFileName = "FileClass.java";
            
            //read input of character data from the file
            FileReader fr = new FileReader(inputFileName);
            
            
            //read text from a character-input stream. adds buffering allowing to read a line at a time.
            BufferedReader br = new BufferedReader(fr);
            
            
            String str;
            while((str = br.readLine()) != null){
                sb.append(str);
                sb.append("\n");
                
            }
            br.close();
        }
        catch(IOException e){
            System.out.println("IOException:");
            e.printStackTrace();
        }
        return sb.toString();
        

    }
    
    public static void writeFile(){
        
         StringBuffer sb = new StringBuffer();
        
        try{

             
            //string object for a reversed input from reader
            String outputFileName = "ReversedFileClass.txt";
            
            //print the modified string from the old file to the new file
            PrintWriter pw = new PrintWriter(outputFileName);

            String str = readFile();
                sb.append(str);
                sb.reverse();
                pw.println(sb.toString());
                pw.close();

        }
        catch(IOException e){
            System.out.println("IOException:");
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }

}