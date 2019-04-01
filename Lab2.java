import java.io.*;
import java.util.Scanner;

public class Lab2 {
  public static void main (String [] args) throws IOException {
    Scanner keyboard = new Scanner(System.in);
    
    int [] nums = new int [12];
     read(nums);
      System.out.println("Enter a number: " );
      while(keyboard.hasNext()) {
    int key = keyboard.nextInt();
      
      if(searchSeq(nums,key) == -1) {
        System.out.println("not found"); }
      else  { System.out.println("found at location" + searchSeq(nums,key));
      }
      System.out.println("Enter a number: " );
  }
  }
 
    public static void read(int [] nums) throws IOException {
      Scanner scanner = new Scanner(new File("numsforlab.text"));
      for(int i = 0; i <12; i++) {
        nums[i] = scanner.nextInt();
      }
    }
    public static int searchSeq(int [] nums, int key) {
      for(int i = nums.length -1; i >=0; i--) {
      if(nums[i] == key) 
        return i+1;
      }
  return -1;  }
}
    