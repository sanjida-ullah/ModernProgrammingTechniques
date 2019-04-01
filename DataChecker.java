import java.io.*;
import java.util.Scanner;

public class DataChecker{
  public static void main (String[] args) throws IOException { 
    
    Scanner fileScanner = new Scanner(new File("numbersforlab4.text"));
    int counter = 0;
    int counter2 = 1;

    while (fileScanner.hasNext()) { 
      
      try {
        average(String line = fileScanner.nextLine());
        Scanner lineScanner = new Scanner(line);
        counter++;
        double sum =0;
        
        int size = lineScanner.nextInt();
        int [] nums = new int [size];
        if (size==0) throw new Exception("Header value of 0 - average can't be taken");
        if (size < 0) throw new Exception("Corrupt line - negative header value");
        
        
        for(int i =0; i < size; i++)
        {
          nums[i] = lineScanner.nextInt();
        }
        System.out.print("The average of the values on line " + counter);
        for(int i =0; i < size; i++) 
          sum+= nums[i];
        if (nums.length > size) throw new Exception ("Corrupt line - extra values on line");
        System.out.print(" is " + (sum/size));  
        System.out.println("");
       
      }
      catch (Exception e) {
        counter2++;
        System.out.println("*** Error (line " +counter+ "): " + e.getMessage());
   
      }   
    }
    System.out.println((counter-counter2) + " sets of valid lines of data");
    System.out.println(counter2 + " corrupt lines of data");
  }
  public static int average(String line) { 
    Scanner lineScanner = new Scanner(line);
}

