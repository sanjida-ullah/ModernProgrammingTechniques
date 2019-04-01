import java.io.*;
import java.util.Scanner;

public class Lab31 { 
  public static void main(String [] args) throws IOException {
    Scanner infile= new Scanner(new File("numsforlab.text"));
    int size = infile.nextInt();
    double [] nums = new double [size];
    readFile(nums, infile);
    findminmax(nums);
  }
    
    public static void readFile(double [] nums, Scanner infile) {
      for(int i =0; i<nums.length; i++)
        nums[i] = infile.nextDouble();
    }
    public static void findminmax(double [] nums) {
      double min= 1000;
      double max= 0;
      int minindex=0;
      int maxindex= 0;
      for(int i=0; i<nums.length; i++) {
        if(nums[i] < min) {
          min = nums[i];
          minindex=i; }
        if(nums[i] > max) {
          max= nums[i];
          maxindex=i;
        }
      }
        System.out.println(max + "is the greatest number");
    }
  }
        
    
    