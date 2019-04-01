import java.io.*;
import java.util.Scanner;

public class LineScanner {
  public static void main (String [] args) throws IOException{
    try {
      Scanner fileScanner = new Scanner(new File("numberfile.text"));
    
    
    int counter = 0;
    
    while (fileScanner.hasNext()) { 
    
      try {
        String line = fileScanner.nextLine(); 
        Scanner lineScanner = new Scanner(line);
        counter++;
        String whatsInHere = lineScanner.nextLine(); 
        System.out.print("There are ");
        System.out.print(whatsInHere.trim().split(" ").length);
        System.out.print(" numbers on line " + counter);
        int nums[
        System.out.println();
      }
      catch (Exception e) { System.out.println("There are 0 numbers on line " + counter); }  
    
    }
  }
    catch (FileNotFoundException exception) { System.out.println("File not found."); }
  }
}

