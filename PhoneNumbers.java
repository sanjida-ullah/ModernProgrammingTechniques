import java.io.*;
import java.util.Scanner;

public class PhoneNumbers{ 
  private String num;
  public PhoneNumbers(String num) {
    this.num= num;
  }
  public String getAreacode() {return num.substring(1,4); }
  public boolean equals(PhoneNumbers other){ return num.equals(other.num);}
  public boolean isTollFree(){ return "8".equals(num.substring(1,2));}
  public String toString() { return num;}
  
  public static PhoneNumbers read(Scanner scanner) {
    if(!scanner.hasNext()) return null;
   String num= scanner.next();
    return new PhoneNumbers(num);}
  public static void main(String [] args) throws IOException{
   Scanner scanner= new Scanner(new File("numbers.txt"));
   int counter = 0;
   PhoneNumbers other = new PhoneNumbers(" ");
  PhoneNumbers num= read(scanner);
  while(num != null) {
    if(num.equals(other)) {
      System.out.println("dup found");}
      else {
        System.out.println(num.toString()); }
        counter++;
        other = num;
        num= read(scanner);
  }
    System.out.println(counter + "processed");
      }
     
  
  }




  
    